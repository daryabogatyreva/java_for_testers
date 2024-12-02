package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.stqa.mantis.common.Common;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    @Test
    void canUserRegister() throws IOException {
        var user = app.developerMail().addUser();
        var email = String.format("%s@developermail", user.name());
        app.userHelper().signUpNewAccount(user.name(), email);
        var messages = app.developerMail().receive(user, Duration.ofSeconds(10));
        var url = app.developerMail().extractUrl(messages);
        app.http().completeRegistration(url);
        app.userHelper().setPassword(user.name(), url);
        try {
            app.http().login(user.name(), "password");
        } catch (IOException e) {
            throw new RuntimeException("Пользователь не найден");
        }
        try {
            app.session().login(user.name(), "password");
            Assertions.assertTrue(app.http().isLoggedIn());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка логина");
        }
    }
}

package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.io.IOException;
import java.time.Duration;

public class UserCreationTests extends TestBase {
    DeveloperMailUser user;

    @Test
    void canCreateUser() throws IOException {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        app.userHelper().startCreation(user.name(), email);
        var message = app.developerMail().receive(user, Duration.ofSeconds(10));
        var url = app.developerMail().extractUrl(message);
        app.userHelper().finishCreation(url, password);
        app.http().login(user.name(), password);
        try {
            Assertions.assertTrue(app.http().isLoggedIn());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(user);
    }
}

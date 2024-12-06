package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.stqa.mantis.common.Common;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.IssueData;
import ru.stqa.mantis.model.UserData;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTests extends TestBase {
    DeveloperMailUser user;

    @Test
    void canUserRegister() throws IOException {
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        app.userHelper().signUpNewAccount(user.name(), email);
        var messages = app.developerMail().receive(user, Duration.ofSeconds(610));
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

    @Test
    void canUserRegisterRest() throws IOException {
        var userName = Common.randomString(8);
        var email = String.format("%s@localhost", userName);
        app.jamesApi().addUser(email, "password");
        UserData userData = new UserData().withRealName(Common.randomString(6))
                                         .withUserName(userName)
                                         .withPassword("password")
                                         .withEmail(email);
        app.rest().createUser(userData);
        System.out.println("User created: " + userData);
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(20));
        var url = app.mail().extractUrl(messages);
        app.http().completeRegistration(url);
        app.userHelper().setPassword(userName, url);
        try {
            app.http().login(userName, "password");
        } catch (IOException e) {
            throw new RuntimeException("Пользователь не найден");
        }
        try {
            app.session().login(userName, "password");
            Assertions.assertTrue(app.http().isLoggedIn());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка логина");
        }
    }

    @Test
    void canCreateUserRest(){
        UserData userData = new UserData().withRealName(Common.randomString(6))
                                          .withUserName("userName")
                                          .withPassword("password")
                                          .withEmail("email");
        app.rest().createUser(userData);
        System.out.println("User created: " + userData);
    }

}

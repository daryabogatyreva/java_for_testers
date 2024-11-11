package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    @Test
    void canUserRegister() throws IOException {
        var username = Common.randomString(6);
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email, "password"); //создать пользователя (адрес) на почтовом сервере
        app.userHelper().signUpNewAccount(username, email); //заполнить форму создания и отправить
        var messages = app.mail().receive(String.format("%s@localhost", username), "password", Duration.ofSeconds(10));  //ждем почту
        var url = app.mail().extractUrl(messages); //извлечь ссылку из письма
        app.http().completeRegistration(url); //пройти по ссылке
        app.userHelper().setPassword(username, url); //закончить регистрацию
        try {
            app.http().login(username, "password"); //логинимся под новым пользователем
        } catch (IOException e) {
            throw new RuntimeException("Пользователь не найден");
        }
        try {
            app.session().login(username, "password");
            Assertions.assertTrue(app.http().isLoggedIn());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка логина"); //проверка, что пользователь смог залогиниться
        }
    }
}

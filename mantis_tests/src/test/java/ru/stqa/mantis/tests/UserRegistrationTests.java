package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class UserRegistrationTests extends TestBase{
    @Test
    void canUserRegister(String username){
        var email = String.format("%s@localhost", username);
        //создать пользователя (адрес) на почтовом сервере (JamesHelper)
        //заполнить форму создания и отправить (браузер - создать помощника)
        //ждем почту (MAilHelper)
        //извлечь ссылку из письма
        //пройти по ссылке и завершить регистрацию пользователя (браузер)
        //проверка, что пользователь может залогиниться (HttpSessionHelper)
    }
}

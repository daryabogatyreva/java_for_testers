package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoginTests extends TestBase {

    @Test
    void canLogin() throws IOException {
        app.http().login("administrator", "root");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
    @Test
    void canLoginInBrowser() {
        app.session().login("administrator", "root");
        Assertions.assertTrue(app.session().isLoggedIn());
    }



}

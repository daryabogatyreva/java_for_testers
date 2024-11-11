package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;

public class JamesTests extends TestBase{

    @Test
    void canCreateUser () {
        app.jamesCli().addUser(String.format("%s@localhost", Common.randomString(8)), "password");
    }

}

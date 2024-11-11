package ru.stqa.mantis.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class registerUserHelper extends HelperBase {

    public registerUserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void signUpNewAccount(String username, String email){
        click(By.xpath("//*[@id=\"login-box\"]/div/div[2]/a"));
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.xpath("//*[@id=\"signup-form\"]/fieldset/input[2]"));
        click(By.xpath("//*[@id=\"login-box\"]/div/div/div[4]/a"));
    }

    public void setPassword(String username, String url) {
        loadPage(url);
        type(By.name("realname"), username);
        type(By.name("password"), "password");
        type(By.name("password_confirm"), "password");
        click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button"));
    }
}

package ru.stqa.mantis.manager;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.io.IOException;
import java.net.CookieManager;

public class UserHelper extends HelperBase {
    OkHttpClient client;

    public UserHelper(ApplicationManager manager) {

        super(manager);
        client = new OkHttpClient.Builder().cookieJar(new JavaNetCookieJar(new CookieManager())).build();
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

    public void startCreation(String user, String email) {
        if(!manager.session().isLoggedIn()) {
            manager.session().login(manager.property("web.username"), manager.property("web.password"));
        }
        manager.driver().get(String.format("%s/manage_user_create_page.php", manager.property("web.baseURL")));
        type(By.name("username"), user);
        type(By.name("realname"), user);
        type(By.name("email"), email);
        click(By.cssSelector("input[type = 'submit']"));
    }

    public void finishCreation(String url, String password) {
        loadPage(url);
        type(By.name("password"), password);
        type(By.name("password_confirm"), "password");
        click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button"));
    }
}

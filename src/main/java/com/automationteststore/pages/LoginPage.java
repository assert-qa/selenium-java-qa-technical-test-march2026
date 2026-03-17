package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By LOGIN_FORM = By.id("loginFrm");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage waitUntilLoaded() {
        wait.visible(LOGIN_FORM);
        return this;
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl + "/index.php?rt=account/login");
        return waitUntilLoaded();
    }
}


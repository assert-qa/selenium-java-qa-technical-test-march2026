package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import com.automationteststore.components.TopNavComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final By HOME_SLIDER = By.id("maincontainer");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String baseUrl) {
        driver.get(baseUrl);
        wait.visible(HOME_SLIDER);
        return this;
    }

    public TopNavComponent topNav() {
        return new TopNavComponent(driver);
    }
}


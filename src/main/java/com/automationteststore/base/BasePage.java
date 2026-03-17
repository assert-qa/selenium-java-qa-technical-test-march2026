package com.automationteststore.base;

import com.automationteststore.core.config.ConfigManager;
import com.automationteststore.core.wait.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WaitHelper wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, ConfigManager.getInt("timeout.seconds", 15));
    }

    protected void click(By locator) {
        wait.clickable(locator).click();
    }

    protected void type(By locator, String text) {
        wait.visible(locator).clear();
        wait.visible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.visible(locator).getText().trim();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


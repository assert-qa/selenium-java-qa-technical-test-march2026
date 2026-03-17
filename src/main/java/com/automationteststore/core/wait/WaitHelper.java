package com.automationteststore.core.wait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    private final WebDriverWait wait;

    public WaitHelper(WebDriver driver, int timeoutSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean urlContains(String urlPart) {
        return wait.until(ExpectedConditions.urlContains(urlPart));
    }

    public boolean titleContains(String titlePart) {
        return wait.until(ExpectedConditions.titleContains(titlePart));
    }
}


package com.automationteststore.support;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class AllureAttachmentHelper {
    private AllureAttachmentHelper() {
    }

    public static void attachScreenshot(WebDriver driver, String name) {
        if (!(driver instanceof TakesScreenshot screenshotDriver)) {
            return;
        }

        byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshot), "png");
    }
}


package com.automationteststore.support;

import com.automationteststore.core.driver.DriverManager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

public class FailureWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            WebDriver driver = DriverManager.getDriver();
            String name = "FAILED-" + context.getDisplayName().replace(' ', '_');
            AllureAttachmentHelper.attachScreenshot(driver, name);
        } catch (IllegalStateException ignored) {
            // Driver is not available for this test lifecycle.
        }
    }
}


package com.automationteststore.base;

import com.automationteststore.core.config.ConfigManager;
import com.automationteststore.core.driver.DriverFactory;
import com.automationteststore.core.driver.DriverManager;
import com.automationteststore.support.AllureEnvironmentExtension;
import com.automationteststore.support.FailureWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith({AllureEnvironmentExtension.class, FailureWatcher.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = ConfigManager.getString("baseUrl");
        driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);
    }

    @AfterEach
    void tearDown() {
        DriverManager.unload();
    }
}


package com.automationteststore.core.driver;

import com.automationteststore.core.config.ConfigManager;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        String browser = ConfigManager.getString("browser").toLowerCase();
        boolean headless = ConfigManager.getBoolean("headless", true);

        WebDriver driver = switch (browser) {
            case "firefox" -> createFirefoxDriver(headless);
            case "edge" -> createEdgeDriver(headless);
            default -> createChromeDriver(headless);
        };

        int timeoutSeconds = ConfigManager.getInt("timeout.seconds", 15);
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeoutSeconds));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutSeconds * 2L));
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
        if (headless) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (headless) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (headless) {
            options.addArguments("--headless=new");
        }
        return new EdgeDriver(options);
    }
}


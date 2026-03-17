package com.automationteststore.core.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	private DriverManager() {
	}

	public static void setDriver(WebDriver webDriver) {
		DRIVER.set(webDriver);
	}

	public static WebDriver getDriver() {
		WebDriver webDriver = DRIVER.get();
		if (webDriver == null) {
			throw new IllegalStateException("WebDriver is not initialized for this thread.");
		}
		return webDriver;
	}

	public static void unload() {
		WebDriver webDriver = DRIVER.get();
		if (webDriver != null) {
			webDriver.quit();
			DRIVER.remove();
		}
	}
}


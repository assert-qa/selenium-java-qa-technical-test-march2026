package com.automationteststore.pages;

import com.automationteststore.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private static final By RESULTS_CONTAINER = By.id("maincontainer");
    private static final By BREADCRUMB = By.cssSelector(".breadcrumb");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage openWithKeyword(String baseUrl, String keyword) {
        driver.get(baseUrl + "/index.php?rt=product/search&keyword=" + keyword);
        return waitUntilLoaded();
    }

    public SearchResultsPage waitUntilLoaded() {
        wait.visible(RESULTS_CONTAINER);
        return this;
    }

    public String breadcrumbText() {
        return getText(BREADCRUMB);
    }
}


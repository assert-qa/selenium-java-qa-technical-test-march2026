package com.automationteststore.components;

import com.automationteststore.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavComponent extends BasePage {
    private static final By SEARCH_INPUT = By.id("filter_keyword");
    private static final By SEARCH_BUTTON = By.cssSelector("button.button-in-search");
    private static final By LOGIN_LINK = By.cssSelector("#customer_menu_top a");

    public TopNavComponent(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String keyword) {
        type(SEARCH_INPUT, keyword);
        click(SEARCH_BUTTON);
    }

    public void clickLoginMenu() {
        click(LOGIN_LINK);
    }
}


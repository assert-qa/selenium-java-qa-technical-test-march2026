package com.automationteststore.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Home")
class HomePageTest extends BaseTest {

    @Test
    @Tag("smoke")
    @Story("Open storefront home page")
    @DisplayName("Home page can be opened successfully")
    void shouldOpenHomePage() {
        HomePage homePage = new HomePage(driver).open(baseUrl);

        assertThat(homePage.getCurrentUrl()).contains("automationteststore.com");
        assertThat(homePage.getTitle()).containsIgnoringCase("automation");
    }

    @Test
    @Tag("smoke")
    @Story("Home page enforces secure protocol")
    @DisplayName("Home page uses HTTPS and has non-empty title")
    void shouldUseHttpsOnHomePage() {
        HomePage homePage = new HomePage(driver).open(baseUrl);

        assertThat(homePage.getCurrentUrl()).startsWith("https://");
        assertThat(homePage.getTitle()).isNotBlank();
    }
}


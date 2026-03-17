package com.automationteststore.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Account Navigation")
class NavigationTest extends BaseTest {

    @Test
    @Tag("smoke")
    @Story("Navigate to login page")
    @DisplayName("User can navigate to login page")
    void shouldNavigateToLoginPage() {
        LoginPage loginPage = new LoginPage(driver).open(baseUrl);

        assertThat(loginPage.getCurrentUrl()).contains("account/login");
    }

    @Test
    @Tag("regression")
    @Story("Navigate to registration page")
    @DisplayName("User can navigate to account registration page")
    void shouldNavigateToRegisterPage() {
        driver.get(baseUrl + "/index.php?rt=account/create");

        assertThat(driver.getCurrentUrl()).contains("account/create");
        assertThat(driver.getTitle()).isNotBlank();
    }
}


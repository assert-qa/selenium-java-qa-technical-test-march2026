package com.automationteststore.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.automationteststore.base.BaseTest;
import com.automationteststore.pages.SearchResultsPage;
import com.automationteststore.testdata.SearchCase;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Feature("Search")
class SearchTest extends BaseTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("com.automationteststore.testdata.SearchTestDataFactory#regressionCases")
    @Tag("regression")
    @Story("Search product by keyword")
    @DisplayName("User can open product search flow from JSON dataset")
    void shouldSearchProduct(SearchCase searchCase) {
        Allure.label("scenario", searchCase.toString());
        Allure.parameter("keyword", searchCase.getKeyword());

        SearchResultsPage resultsPage = new SearchResultsPage(driver).openWithKeyword(baseUrl, searchCase.getKeyword());
        assertThat(resultsPage.getCurrentUrl()).contains(searchCase.getExpectedUrlContains());
        assertThat(resultsPage.breadcrumbText()).isNotBlank();
    }
}


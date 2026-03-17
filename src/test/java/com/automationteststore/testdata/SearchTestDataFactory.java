package com.automationteststore.testdata;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public final class SearchTestDataFactory {
    private static final String SEARCH_CASES_FILE = "testdata/search/search-cases.json";

    private SearchTestDataFactory() {
    }

    public static Stream<Arguments> regressionCases() {
        List<SearchCase> searchCases = JsonTestDataLoader.loadList(
                SEARCH_CASES_FILE,
                new TypeReference<>() {
                }
        );

        return searchCases.stream().map(Arguments::of);
    }
}


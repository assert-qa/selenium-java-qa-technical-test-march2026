package com.automationteststore.testdata;

public class SearchCase {
    private String name;
    private String keyword;
    private String expectedUrlContains;

    public SearchCase() {
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getExpectedUrlContains() {
        return expectedUrlContains;
    }

    @Override
    public String toString() {
        return name == null || name.isBlank() ? keyword : name;
    }
}


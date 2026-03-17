package com.automationteststore.testdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JsonTestDataLoader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonTestDataLoader() {
    }

    public static <T> List<T> loadList(String resourcePath, TypeReference<List<T>> typeReference) {
        try (InputStream inputStream = JsonTestDataLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalStateException("Test data file not found: " + resourcePath);
            }
            return OBJECT_MAPPER.readValue(inputStream, typeReference);
        } catch (IOException exception) {
            throw new IllegalStateException("Failed to read test data: " + resourcePath, exception);
        }
    }
}


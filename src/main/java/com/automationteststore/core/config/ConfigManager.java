package com.automationteststore.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class ConfigManager {
    private static final String DEFAULT_CONFIG_PATH = "config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigManager() {
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(DEFAULT_CONFIG_PATH)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Failed to read config.properties", exception);
        }
        return properties;
    }

    public static String getString(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String envValue = System.getenv(toEnvKey(key));
        if (envValue != null && !envValue.isBlank()) {
            return envValue;
        }

        return Objects.requireNonNullElse(PROPERTIES.getProperty(key), "").trim();
    }

    public static int getInt(String key, int defaultValue) {
        String value = getString(key);
        if (value.isBlank()) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = getString(key);
        if (value.isBlank()) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    private static String toEnvKey(String key) {
        return key.toUpperCase().replace('.', '_');
    }
}


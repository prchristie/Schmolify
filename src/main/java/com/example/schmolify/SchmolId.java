package com.example.schmolify;

import java.util.regex.Pattern;

public class SchmolId {
    private final static Pattern ALPHANUMERIC_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    private final String value;

    private SchmolId(String value) {
        this.value = value;
    }

    public static SchmolId create(String value) {
        if (value.length() != 8 || ALPHANUMERIC_PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException("Schmol ID must be 8 characters long");
        }
        return new SchmolId(value);
    }

    public String getValue() {
        return value;
    }
}

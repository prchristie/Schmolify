package com.example.schmolify.domain;

import java.util.regex.Pattern;

public record SchmolId(String value) {
    private final static Pattern ALPHANUMERIC_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

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

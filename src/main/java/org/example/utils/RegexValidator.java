package org.example.utils;

public class RegexValidator {
    private final static String REGEX = "^[0-9]*[.,]?[0-9]+$";

    public static boolean isValid(String regexp) {
        return regexp.isEmpty() || !regexp.matches(REGEX);
    }
}

package org.example.exception;

import java.util.HashMap;
import java.util.Map;

public class ProductDataException extends RuntimeException {
    Map<String, String> errors;

    public ProductDataException(String msg, Map<String, String> errors) {
        super(msg);
        this.errors = errors;
    }

    public String getErrors(Map<String, String> errors) {
        this.errors = new HashMap<>();
        StringBuilder errorsBuilder = new StringBuilder();
        errors.forEach((key, value) -> errorsBuilder.append("\n>> ").append(key).append(": ")
                .append(value).append("\n"));
        return errorsBuilder.toString();
    }
}

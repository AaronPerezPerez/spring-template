package com.springexample.main.api.shared;

public record ExceptionDTO(String message) {
    public static ExceptionDTO from(Exception exception) {
        return new ExceptionDTO(exception.getMessage());
    }
}

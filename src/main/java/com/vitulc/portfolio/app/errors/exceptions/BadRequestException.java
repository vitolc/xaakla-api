package com.vitulc.portfolio.app.errors.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}


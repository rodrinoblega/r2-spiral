package com.r2.spiral.adapters.request.validations;

public class RequestValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequestValidationException(String message) {
        super(message);
    }
}

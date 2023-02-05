package com.inventiv.demo.exceptions;

public class CaseAlreadyExistsException  extends RuntimeException {
    public CaseAlreadyExistsException(String message) {
        super(message);
    }

    public CaseAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.example.dynamicmapping.persistence.exception;

public class JsonNotParsedException extends RuntimeException {
    public JsonNotParsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonNotParsedException(Throwable cause) {
        super(cause);
    }
}

package org.example.library;

public class AlreadyReturnedException extends RuntimeException {
    public AlreadyReturnedException(String message) {
        super(message);
    }
}
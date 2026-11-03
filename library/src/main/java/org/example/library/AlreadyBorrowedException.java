package org.example.library;

public class AlreadyBorrowedException extends Exception {
    public AlreadyBorrowedException(String message) {
        super(message);
    }
}
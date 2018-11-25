package com.springer.demo.exeption;

/**
 * Custom exception for invalid input
 */
public class InvalidCommandException
        extends RuntimeException {
    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }
}
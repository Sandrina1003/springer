package com.springer.demo.exeption;

public class InvalidCommandException
  extends RuntimeException {
    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }
}
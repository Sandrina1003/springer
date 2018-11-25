package com.springer.demo.service;

import com.springer.demo.exeption.InvalidCommandException;

public class ValidatorService {

    public void validateLineParameters(int x1, int y1, int x2, int y2) {
        if (x1 != x2 && y1 != y2) {
            throw new InvalidCommandException("Only horizontal and vertical lines are supported");
        }
    }

    public void validateCanvasIsInitialized(char[][] canvas) {
        if (canvas == null) {
            throw new InvalidCommandException("Canvas should be initialized first");
        }
    }

    public void validateParametersSize(String[] parameters, int size) {
        if (parameters.length != size) {
            throw new InvalidCommandException("Invalid parameters size");
        }
    }

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException("Command not valid");
        }
    }
}

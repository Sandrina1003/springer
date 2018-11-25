package com.springer.demo.service;

import com.springer.demo.exeption.InvalidCommandException;

/**
 * service used to handle all input validations
 */
public class ValidatorService {

    /**
     * Validates that canvas size is positive number
     *
     * @param width  - canvas width
     * @param height - canvas height
     */
    public void validateCanvasSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new InvalidCommandException("Invalid canvas size");

        }
    }

    /**
     * Validates that line coordinates correspond to horizontal or vertical line
     *
     * @param x1 - coordinate x of start point
     * @param y1 - coordinate y of start point
     * @param x2 - coordinate x of end point
     * @param y2 - coordinate y of end point
     */
    public void validateLineParameters(int x1, int y1, int x2, int y2) {
        if (x1 != x2 && y1 != y2) {
            throw new InvalidCommandException("Only horizontal and vertical lines are supported");
        }
    }

    /**
     * Validates if canvas is initialized
     *
     * @param canvas - canvas to be validated
     */
    public void validateCanvasIsInitialized(char[][] canvas) {
        if (canvas == null) {
            throw new InvalidCommandException("DrawingCanvas should be initialized first");
        }
    }

    /**
     * Validates input parameters size
     *
     * @param parameters - list of parameters to be validated
     * @param size       - expected size
     */
    public void validateParametersSize(String[] parameters, int size) {
        if (parameters.length != size) {
            throw new InvalidCommandException("Invalid parameters size");
        }
    }

    /**
     * Validates that user input is not empty or null
     *
     * @param input - user input
     */
    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException("Command not valid");
        }
    }

    /**
     * Validates that the given point belong on the canvas
     *
     * @param canvas - canvas
     * @param x      - coordinate x
     * @param y      - coordinate y
     */
    public void validateCoordinateInCanvas(char[][] canvas, int x, int y) {
        if ((x < 1 || x >= canvas.length - 1) || (y <= 0 || y >= canvas[0].length - 1)) {
            throw new InvalidCommandException(
                    String.format("Coordinate {%s,%s} is not in the canvas", x, y));
        }
    }
}

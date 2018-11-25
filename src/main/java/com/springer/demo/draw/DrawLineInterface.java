package com.springer.demo.draw;

/**
 * Handles drawing of horizontal and vertical lines on canvas
 */
public interface DrawLineInterface {

    default void drawHorizontalLine(char[][] canvas, int x1, int y1, int x2) {
        for (int i = x1; i <= x2; i++) {
            canvas[y1][i] = 'x';
        }
    }

    default void drawVerticalLine(char[][] canvas, int x1, int y1, int y2) {
        for (int i = y1; i <= y2; i++) {
            canvas[i][x1] = 'x';
        }
    }
}

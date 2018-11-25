package com.springer.demo.canvas;

/**
 * Interface containing all canvas operations
 */
public interface Canvas {

    /**
     * Initializes canvas matrix
     *
     * @param width  - canvas width
     * @param height - canvas height
     */
    void init(int width, int height);

    /**
     * Draws horizontal or vertical line on canvas
     *
     * @param x1 - x coordinate of start point
     * @param y1 - y coordinate of start point
     * @param x2 - x coordinate of end point
     * @param y2 - y coordinate of end point
     */
    void drawLine(int x1, int y1, int x2, int y2);

    /**
     * Draws a rectangle on canvas
     *
     * @param x1 - x coordinate of upper left corner
     * @param y1 - y coordinate of upper left corner
     * @param x2 - x coordinate of lower right corner
     * @param y2 - y coordinate of lower right corner
     */
    void drawRectangle(int x1, int y1, int x2, int y2);

    /**
     * Fills connected area with given color
     *
     * @param x     - coordinate x of start point
     * @param y     - coordinate y of start point
     * @param color - color
     */
    void fillArea(int x, int y, char color);

    /**
     * Quits the application
     */
    void quit();

    /**
     * prints the current state on canvas
     */
    void printCanvas();
}

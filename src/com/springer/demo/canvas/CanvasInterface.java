package com.springer.demo.canvas;

public interface CanvasInterface {

    void init(int width, int height);

    void drawLine(int x1, int y1, int x2, int y2);

    void drawRectangle(int x1, int y1, int x2, int y2);

    void fillArea(int x1, int y1, char color);

    void quit();

    void printCanvas();
}

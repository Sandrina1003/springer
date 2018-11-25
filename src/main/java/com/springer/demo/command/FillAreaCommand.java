package com.springer.demo.command;

import com.springer.demo.canvas.Canvas;

public class FillAreaCommand implements DrawCommand{

    private Canvas canvas;
    private int x;
    private int y;
    private char color;

    public FillAreaCommand(Canvas canvas, int x, int y, char color) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.color=color;
    }

    @Override
    public void execute() {
        canvas.fillArea(x, y, color);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}

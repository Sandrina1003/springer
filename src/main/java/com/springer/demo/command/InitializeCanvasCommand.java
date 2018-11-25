package com.springer.demo.command;

import com.springer.demo.canvas.Canvas;


/**
 * Command that handles canvas initialization
 */
public class InitializeCanvasCommand implements DrawCommand {

    private Canvas canvas;
    private int width;
    private int height;

    public InitializeCanvasCommand(Canvas canvas, int width, int height) {
        this.canvas = canvas;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        canvas.init(width, height);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

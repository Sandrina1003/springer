package com.springer.demo.command;

import com.springer.demo.canvas.CanvasInterface;

public class InitializeCanvasCommand implements DrawCommand {

    private CanvasInterface canvas;
    private int width;
    private int height;

    public InitializeCanvasCommand(CanvasInterface canvas, int width, int height) {
        this.canvas = canvas;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        canvas.init(width, height);
    }
}

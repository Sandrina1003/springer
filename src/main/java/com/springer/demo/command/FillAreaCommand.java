package com.springer.demo.command;

import com.springer.demo.canvas.CanvasInterface;

public class FillAreaCommand implements DrawCommand{

    private CanvasInterface canvas;
    private int x1;
    private int y1;
    private char color;

    public FillAreaCommand(CanvasInterface canvas, int x1, int y1, char color) {
        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.color=color;
    }

    @Override
    public void execute() {
        canvas.fillArea(x1, y1, color);
    }
}

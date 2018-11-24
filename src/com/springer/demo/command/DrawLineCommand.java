package com.springer.demo.command;

import com.springer.demo.canvas.CanvasInterface;

public class DrawLineCommand implements DrawCommand {

    private CanvasInterface canvas;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawLineCommand(CanvasInterface canvas, int x1, int y1, int x2, int y2) {
        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void execute() {
        canvas.drawLine(x1, y1, x2, y2);
    }
}

package com.springer.demo.command;

import com.springer.demo.canvas.Canvas;

public class QuitCommand implements DrawCommand {

    private Canvas canvas;

    public QuitCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.quit();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}

package com.springer.demo.command;

import com.springer.demo.canvas.CanvasInterface;

public class QuitCommand implements DrawCommand {

    private CanvasInterface canvas;

    public QuitCommand(CanvasInterface canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.quit();
    }
}

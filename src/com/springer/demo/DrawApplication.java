package com.springer.demo;

import com.springer.demo.canvas.Canvas;
import com.springer.demo.canvas.CanvasInterface;

public class DrawApplication {

    public static void main(String[] args) {
        CanvasInterface canvas = new Canvas();
        canvas.init(20, 4);
        canvas.printCanvas();
        canvas.drawLine(1, 2, 6, 2);
        canvas.printCanvas();
        canvas.drawLine(6, 3, 6, 4);
        canvas.printCanvas();
        canvas.drawRectangle(16, 1, 20, 3);
        canvas.printCanvas();
        canvas.fillArea(10, 3, 'o');
        canvas.printCanvas();
    }
}

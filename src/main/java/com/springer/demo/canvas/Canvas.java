package com.springer.demo.canvas;

import com.springer.demo.draw.DrawLine;
import com.springer.demo.service.ValidatorService;

import java.util.ArrayDeque;

public class Canvas implements CanvasInterface {

    public char[][] canvas = null;
    private ValidatorService validatorService = new ValidatorService();
    private DrawLine drawLine = new DrawLine();

    @Override
    public void init(int width, int height) {
        width = width + 2;
        height = height + 2;
        canvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            canvas[i][0] = '|';
            canvas[i][width - 1] = '|';
        }

        for (int i = 0; i < width; i++) {
            canvas[0][i] = '-';
            canvas[height - 1][i] = '-';
        }

        for (int i = 1; i < height - 1; i++)
            for (int j = 1; j < width - 1; j++) {
                canvas[i][j] = ' ';
            }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        validatorService.validateLineParameters(x1, y1, x2, y2);
        validatorService.validateCanvasIsInitialized(canvas);

        if (y1 == y2) {
            drawLine.drawHorizontalLine(canvas, x1, y1, x2);
        } else {
            drawLine.drawVerticalLine(canvas, x1, y1, y2);
        }

    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        validatorService.validateCanvasIsInitialized(canvas);

        for (int i = x1; i <= x2; i++) {
            canvas[y1][i] = 'x';
            canvas[y2][i] = 'x';
        }

        for (int i = y1; i <= y2; i++) {
            canvas[i][x1] = 'x';
            canvas[i][x2] = 'x';
        }
    }

    @Override
    public void fillArea(int x1, int y1, char color) {
        ArrayDeque<int[]> toCheck = new ArrayDeque<>();
        int canvasWidth = canvas[0].length - 2;
        int canvasHeight = canvas.length - 2;
        if (canvas[y1][x1] != ' ') {
            return;
        }

        canvas[y1][x1] = color;
        int[] coordinate = {x1, y1};
        toCheck.add(coordinate);

        while (!toCheck.isEmpty()) {
            int[] currentPosition = toCheck.remove();
            int x = currentPosition[0];
            int y = currentPosition[1];
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i > 0 && i <= canvasWidth && j > 0 && j <= canvasHeight && canvas[j][i] == ' ') {
                        canvas[j][i] = color;
                        int[] coordinate1 = {i, j};
                        toCheck.add(coordinate1);
                    }
                }
            }

        }
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    @Override
    public void printCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }
}

package com.springer.demo.canvas;

import com.springer.demo.draw.DrawLine;
import com.springer.demo.service.ValidatorService;

import java.util.ArrayDeque;

public class DrawingCanvas implements Canvas {

    private char[][] canvasMatrix = null;

    public char[][] getCanvasMatrix() {
        return canvasMatrix;
    }

    public void setCanvasMatrix(char[][] canvasMatrix) {
        this.canvasMatrix = canvasMatrix;
    }

    private ValidatorService validatorService = new ValidatorService();
    private DrawLine drawLine = new DrawLine();

    @Override
    public void init(int width, int height) {
        width = width + 2;
        height = height + 2;
        canvasMatrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            canvasMatrix[i][0] = '|';
            canvasMatrix[i][width - 1] = '|';
        }

        for (int i = 0; i < width; i++) {
            canvasMatrix[0][i] = '-';
            canvasMatrix[height - 1][i] = '-';
        }

        for (int i = 1; i < height - 1; i++)
            for (int j = 1; j < width - 1; j++) {
                canvasMatrix[i][j] = ' ';
            }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        validatorService.validateLineParameters(x1, y1, x2, y2);
        validatorService.validateCanvasIsInitialized(canvasMatrix);

        if (y1 == y2) {
            drawLine.drawHorizontalLine(canvasMatrix, x1, y1, x2);
        } else {
            drawLine.drawVerticalLine(canvasMatrix, x1, y1, y2);
        }

    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        validatorService.validateCanvasIsInitialized(canvasMatrix);

        for (int i = x1; i <= x2; i++) {
            canvasMatrix[y1][i] = 'x';
            canvasMatrix[y2][i] = 'x';
        }

        for (int i = y1; i <= y2; i++) {
            canvasMatrix[i][x1] = 'x';
            canvasMatrix[i][x2] = 'x';
        }
    }

    @Override
    public void fillArea(int x1, int y1, char color) {
        ArrayDeque<int[]> toCheck = new ArrayDeque<>();
        int canvasWidth = canvasMatrix[0].length - 2;
        int canvasHeight = canvasMatrix.length - 2;
        if (canvasMatrix[y1][x1] != ' ') {
            return;
        }

        canvasMatrix[y1][x1] = color;
        int[] coordinate = {x1, y1};
        toCheck.add(coordinate);

        while (!toCheck.isEmpty()) {
            int[] currentPosition = toCheck.remove();
            int x = currentPosition[0];
            int y = currentPosition[1];
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i > 0 && i <= canvasWidth && j > 0 && j <= canvasHeight && canvasMatrix[j][i] == ' ') {
                        canvasMatrix[j][i] = color;
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
        for (int i = 0; i < canvasMatrix.length; i++) {
            for (int j = 0; j < canvasMatrix[i].length; j++) {
                System.out.print(canvasMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

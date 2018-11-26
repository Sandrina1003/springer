package com.springer.demo.canvas;

import com.springer.demo.draw.DrawLine;
import com.springer.demo.service.ValidatorService;

import java.util.ArrayDeque;

public class DrawingCanvas implements Canvas {

    private char[][] canvasMatrix = null;

    char[][] getCanvasMatrix() {
        return canvasMatrix;
    }

    void setCanvasMatrix(char[][] canvasMatrix) {
        this.canvasMatrix = canvasMatrix;
    }

    private ValidatorService validatorService = new ValidatorService();
    private DrawLine drawLine = new DrawLine();

    @Override
    public void init(int width, int height) {
        validatorService.validateCanvasSize(width, height);
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
        validatorService.validateCanvasIsInitialized(canvasMatrix);
        validatorService.validateCoordinateInCanvas(canvasMatrix, x1, y1);
        validatorService.validateCoordinateInCanvas(canvasMatrix, x2, y2);
        validatorService.validateLineParameters(x1, y1, x2, y2);

        if (y1 == y2) {
            drawLine.drawHorizontalLine(canvasMatrix, x1, y1, x2);
        } else {
            drawLine.drawVerticalLine(canvasMatrix, x1, y1, y2);
        }

    }

    @Override
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        validatorService.validateCanvasIsInitialized(canvasMatrix);
        validatorService.validateCoordinateInCanvas(canvasMatrix, x1, y1);
        validatorService.validateCoordinateInCanvas(canvasMatrix, x2, y2);
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
    public void fillArea(int x, int y, char color) {
        validatorService.validateCanvasIsInitialized(canvasMatrix);
        validatorService.validateCoordinateInCanvas(canvasMatrix, x, y);

        ArrayDeque<int[]> toCheck = new ArrayDeque<>();
        char hitColor = canvasMatrix[y][x];
        int canvasWidth = canvasMatrix[0].length - 2;
        int canvasHeight = canvasMatrix.length - 2;
        if (hitColor == color) {
            return;
        }

        canvasMatrix[y][x] = color;
        int[] coordinate = {x, y};
        toCheck.add(coordinate);

        while (!toCheck.isEmpty()) {
            int[] currentPosition = toCheck.remove();
            int currentX = currentPosition[0];
            int currentY = currentPosition[1];
            for (int i = currentX - 1; i <= currentX + 1; i++) {
                for (int j = currentY - 1; j <= currentY + 1; j++) {
                    if (i > 0 && i <= canvasWidth && j > 0 && j <= canvasHeight && canvasMatrix[j][i] == hitColor) {
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
        if (canvasMatrix != null) {
            for (char[] aCanvasMatrix : canvasMatrix) {
                for (char anACanvasMatrix : aCanvasMatrix) {
                    System.out.print(anACanvasMatrix);
                }
                System.out.println();
            }
        }
    }
}

package com.springer.demo.canvas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DrawingCanvasTest {

    private DrawingCanvas canvas = new DrawingCanvas();

    char[][] initialMatrix = {{'-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-'}
    };

    @Test
    public void shouldInitializeCanvas() {

        //when
        canvas.init(3, 3);

        //then
        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(initialMatrix, canvasMatrix);
    }

    @Test
    public void shouldDrawHorizontalLineOnCanvas() {
        //given
        char[][] expectedMatrix = {{'-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', '|'},
                {'|', 'x', 'x', 'x', '|'},
                {'|', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-'}
        };

        //when
        canvas.setCanvasMatrix(initialMatrix);

        //then
        canvas.drawLine(1, 2, 3, 2);

        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(expectedMatrix, canvasMatrix);
    }

    @Test
    public void shouldDrawVerticalLineOnCanvas() {
        //given
        char[][] expectedMatrix = {{'-', '-', '-', '-', '-'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', ' ', '|'},
                {'-', '-', '-', '-', '-'}
        };

        //when
        canvas.setCanvasMatrix(initialMatrix);

        //then
        canvas.drawLine(2, 1, 2, 3);

        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(expectedMatrix, canvasMatrix);
    }

    @Test
    public void shouldDrawRectangleOnCanvas() {
        //given
        char[][] expectedMatrix = {{'-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', '|'},
                {'|', 'x', ' ', 'x', '|'},
                {'|', 'x', 'x', 'x', '|'},
                {'-', '-', '-', '-', '-'}
        };

        //when
        canvas.setCanvasMatrix(initialMatrix);

        //then
        canvas.drawRectangle(1, 1, 3, 3);

        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(expectedMatrix, canvasMatrix);
    }

    @Test
    public void shouldFillAreaOnCanvas() {
        //given
        char[][] initialMatrix = {{'-', '-', '-', '-', '-'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', 'x', '|'},
                {'-', '-', '-', '-', '-'}
        };

        char[][] expectedMatrix = {{'-', '-', '-', '-', '-'},
                {'|', ' ', 'x', 'c', '|'},
                {'|', ' ', 'x', 'c', '|'},
                {'|', ' ', 'x', 'x', '|'},
                {'-', '-', '-', '-', '-'}
        };

        //when
        canvas.setCanvasMatrix(initialMatrix);

        //then
        canvas.fillArea(3, 2, 'c');

        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(expectedMatrix, canvasMatrix);
    }

    @Test
    public void shouldReturnSameCanvasWhenFillAReaHitsX() {
        //given
        char[][] initialMatrix = {{'-', '-', '-', '-', '-'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', ' ', '|'},
                {'|', ' ', 'x', 'x', '|'},
                {'-', '-', '-', '-', '-'}
        };

        //when
        canvas.setCanvasMatrix(initialMatrix);

        //then
        canvas.fillArea(2, 2, 'c');

        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(initialMatrix, canvasMatrix);
    }

    private void verifyCreatedMatrix(char[][] expectedMatrix, char[][] canvasMatrix) {
        for (int i = 0; i < canvasMatrix.length; i++)
            for (int j = 0; j < canvasMatrix[i].length; j++) {
                assertTrue(expectedMatrix[i][j] == canvasMatrix[i][j]);
            }
    }
}
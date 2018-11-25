package com.springer.demo.canvas;

import com.springer.demo.exeption.InvalidCommandException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DrawingCanvasTest {

    private DrawingCanvas canvas = new DrawingCanvas();

    private char[][] initialMatrix = {{'-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-'}
    };

    @Test
    public void shouldInitializeCanvas() {
        //given
        int width = 3;
        int height = 3;

        //when
        canvas.init(width, height);

        //then
        char[][] canvasMatrix = canvas.getCanvasMatrix();
        verifyCreatedMatrix(initialMatrix, canvasMatrix);
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnInitializeCanvasWhenCanvasSizeIsNotValid() {
        //given
        int width = 0;
        int height = 3;

        //when
        canvas.init(width, height);

        //then
        //should throw InvalidCommandException
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
        canvas.setCanvasMatrix(initialMatrix);

        //when
        canvas.drawLine(1, 2, 3, 2);

        //then

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

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawLineWhenCoordinate1IsNotInCanvas() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 0;
        int x2 = 3;
        int y2 = 2;


        //when
        canvas.drawLine(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawLineWhenCoordinate2IsNotInCanvas() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 2;
        int x2 = -3;
        int y2 = 2;


        //when
        canvas.drawLine(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawLineWhenLineIsNotHorizontalNorVertical() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;


        //when
        canvas.drawLine(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawLineWhenCanvasIsNotInitialized() {
        //given
        canvas.setCanvasMatrix(null);

        //when
        canvas.drawLine(1, 2, 3, 2);

        //then
        //should throw InvalidCommandException
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

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawRectangleWhenCanvasIsNotInitialized() {
        //given
        canvas.setCanvasMatrix(null);

        //when
        canvas.drawRectangle(1, 2, 3, 2);

        //then
        //should throw InvalidCommandException
    }


    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawRectangleWhenCoordinate1IsNotInCanvas() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 0;
        int x2 = 3;
        int y2 = 2;


        //when
        canvas.drawRectangle(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnDrawRectangleWhenCoordinate2IsNotInCanvas() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 2;
        int x2 = -3;
        int y2 = 2;


        //when
        canvas.drawRectangle(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
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
    public void shouldReturnSameCanvasWhenFillAreaHitsX() {
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

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnFillAreaWhenCanvasIsNotInitialized() {
        //given
        canvas.setCanvasMatrix(null);

        //when
        canvas.fillArea(1, 2, 'c');

        //then
        //should throw InvalidCommandException
    }


    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionOnFillAreaWhenCoordinateIsNotInCanvas() {
        //given
        canvas.setCanvasMatrix(initialMatrix);
        int x1 = 1;
        int y1 = 0;


        //when
        canvas.fillArea(x1, y1, 'c');

        //then
        //should throw InvalidCommandException
    }

    private void verifyCreatedMatrix(char[][] expectedMatrix, char[][] canvasMatrix) {
        for (int i = 0; i < canvasMatrix.length; i++)
            for (int j = 0; j < canvasMatrix[i].length; j++) {
                assertTrue(expectedMatrix[i][j] == canvasMatrix[i][j]);
            }
    }
}
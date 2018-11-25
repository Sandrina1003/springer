package com.springer.demo.factory;

import com.springer.demo.canvas.DrawingCanvas;
import com.springer.demo.command.*;
import com.springer.demo.exeption.InvalidCommandException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {

    private CommandFactory commandFactory = new CommandFactory();

    @Test
    public void shouldCreateInitializeCanvasCommand() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "C 3 3";

        //when
        DrawCommand command = commandFactory.createCommand(drawingCanvas, input);

        //then
        assertTrue(command instanceof InitializeCanvasCommand);
        InitializeCanvasCommand initializeCanvasCommand = (InitializeCanvasCommand) command;
        assertEquals(drawingCanvas, initializeCanvasCommand.getCanvas());
    }

    @Test
    public void shouldCreateDrawLineCommand() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "L 3 4 3 6";

        //when
        DrawCommand command = commandFactory.createCommand(drawingCanvas, input);

        //then
        assertTrue(command instanceof DrawLineCommand);
        DrawLineCommand drawLineCommand = (DrawLineCommand) command;
        assertEquals(drawingCanvas, drawLineCommand.getCanvas());
        assertEquals(3, drawLineCommand.getX1());
        assertEquals(4, drawLineCommand.getY1());
        assertEquals(3, drawLineCommand.getX2());
        assertEquals(6, drawLineCommand.getY2());

    }

    @Test
    public void shouldCreateDrawRectangleCommand() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "R 3 4 5 6";

        //when
        DrawCommand command = commandFactory.createCommand(drawingCanvas, input);

        //then
        assertTrue(command instanceof DrawRectangleCommand);
        DrawRectangleCommand drawRectangleCommand = (DrawRectangleCommand) command;
        assertEquals(drawingCanvas, drawRectangleCommand.getCanvas());
        assertEquals(3, drawRectangleCommand.getX1());
        assertEquals(4, drawRectangleCommand.getY1());
        assertEquals(5, drawRectangleCommand.getX2());
        assertEquals(6, drawRectangleCommand.getY2());

    }

    @Test
    public void shouldCreateFillAreaCommand() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "B 3 4 c";

        //when
        DrawCommand command = commandFactory.createCommand(drawingCanvas, input);

        //then
        assertTrue(command instanceof FillAreaCommand);
        FillAreaCommand fillAreaCommand = (FillAreaCommand) command;
        assertEquals(drawingCanvas, fillAreaCommand.getCanvas());
        assertEquals(3, fillAreaCommand.getX());
        assertEquals(4, fillAreaCommand.getY());
        assertEquals('c', fillAreaCommand.getColor());
    }

    @Test
    public void shouldCreateQuitCommand() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "Q";

        //when
        DrawCommand command = commandFactory.createCommand(drawingCanvas, input);

        //then
        assertTrue(command instanceof QuitCommand);
        QuitCommand quitCommand = (QuitCommand) command;
        assertEquals(drawingCanvas, quitCommand.getCanvas());
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenInvalidCommandOnInput() {
        //given
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        String input = "X";

        //when
        commandFactory.createCommand(drawingCanvas, input);

        //then
        //InvalidCommandException is expected
    }
}

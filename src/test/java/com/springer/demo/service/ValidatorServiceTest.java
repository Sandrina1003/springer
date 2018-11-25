package com.springer.demo.service;

import com.springer.demo.exeption.InvalidCommandException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorServiceTest {

    private ValidatorService validatorService = new ValidatorService();

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenCanvasIsNotInitialized() {
        //when
        validatorService.validateCanvasIsInitialized(null);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenLineIsNotHorizontalNorVertical() {
        //given line parameters
        int x1 = 2;
        int y1 = 3;
        int x2 = 4;
        int y2 = 5;

        //when
        validatorService.validateLineParameters(x1, y1, x2, y2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenParametersSizeIsLessThanInTheSpecification(){
        //given
        String[] parameters = {"1", "2"};

        //when
        validatorService.validateParametersSize(parameters, 3);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenParametersSizeIsGreaterThanInTheSpecification(){
        //given
        String[] parameters = {"1", "2", "3", "4"};

        //when
        validatorService.validateParametersSize(parameters, 3);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenInputIsEmpty(){
        //given
        String input = "";

        //when
        validatorService.validateInput(input);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenInputIsNull(){
        //when
        validatorService.validateInput(null);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenXCoordinateIsNotInCanvas(){
        //given
        char canvasMatrix[][]={{'-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-'}};

        //when
        validatorService.validateCoordinateInCanvas(canvasMatrix, 4, 2);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenYCoordinateIsNotInCanvas(){
        //given
        char canvasMatrix[][]={{'-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-'}};

        //when
        validatorService.validateCoordinateInCanvas(canvasMatrix, 2, 0);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenOnInitializeCanvasWhenCanvasWidthIsLessThenZero(){
        //given
        int canvasWidth = -1;
        int canvasHeight = 5;

        //when
        validatorService.validateCanvasSize(canvasWidth, canvasHeight);

        //then
        //should throw InvalidCommandException
    }

    @Test(expected = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenOnInitializeCanvasWhenCanvasHeightIsLessThenZero(){
        //given
        int canvasWidth = 3;
        int canvasHeight = -5;

        //when
        validatorService.validateCanvasSize(canvasWidth, canvasHeight);

        //then
        //should throw InvalidCommandException
    }
}
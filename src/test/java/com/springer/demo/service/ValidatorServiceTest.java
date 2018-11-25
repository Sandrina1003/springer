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
        //given
        char[][] canvas = null;

        //when
        validatorService.validateCanvasIsInitialized(canvas);

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
        //given
        String input = null;

        //when
        validatorService.validateInput(input);

        //then
        //should throw InvalidCommandException
    }
}
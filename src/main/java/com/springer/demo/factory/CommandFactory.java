package com.springer.demo.factory;

import com.springer.demo.canvas.Canvas;
import com.springer.demo.command.*;
import com.springer.demo.exeption.InvalidCommandException;
import com.springer.demo.service.ValidatorService;

import java.util.Arrays;

/**
 * Factory for creating command corresponding on user input
 */
public class CommandFactory {

    private ValidatorService validatorService = new ValidatorService();

    /**
     * Creates command depending on user input
     *
     * @param canvas - canvas
     * @param input  - user input
     * @return - corresponding command
     */
    public DrawCommand createCommand(Canvas canvas, String input) {
        validatorService.validateInput(input);
        String[] parameters = Arrays.stream(input.split(" "))
                .map(String::trim)
                .toArray(String[]::new);

        Character operation = parameters[0].charAt(0);
        switch (operation) {
            case 'C': {
                validatorService.validateParametersSize(parameters, 3);
                return new InitializeCanvasCommand(canvas,

                        getParameterValue(parameters[1]),
                        getParameterValue(parameters[2]));
            }
            case 'L': {
                validatorService.validateParametersSize(parameters, 5);

                return new DrawLineCommand(canvas, getParameterValue(parameters[1]),
                        getParameterValue(parameters[2]), getParameterValue(parameters[3]),
                        getParameterValue(parameters[4]));
            }
            case 'R': {
                validatorService.validateParametersSize(parameters, 5);
                return new DrawRectangleCommand(canvas, getParameterValue(parameters[1]), getParameterValue(parameters[2]),
                        getParameterValue(parameters[3]), getParameterValue(parameters[4]));
            }
            case 'B': {
                validatorService.validateParametersSize(parameters, 4);
                return new FillAreaCommand(canvas, getParameterValue(parameters[1]), getParameterValue(parameters[2]),
                        parameters[3].charAt(0));
            }
            case 'Q': {
                validatorService.validateParametersSize(parameters, 1);

                return new QuitCommand(canvas);
            }
            default:
                throw new InvalidCommandException("Command not valid");

        }
    }

    private Integer getParameterValue(String parameter) {
        try {
            return Integer.valueOf(parameter);
        } catch (NumberFormatException ex) {
            throw new InvalidCommandException(String.format("Invalid parameter format %s", parameter));
        }
    }
}
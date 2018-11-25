package com.springer.demo.factory;

import com.springer.demo.canvas.Canvas;
import com.springer.demo.command.*;
import com.springer.demo.exeption.InvalidCommandException;
import com.springer.demo.service.ValidatorService;

import java.util.Arrays;

public class CommandFactory {

    private ValidatorService validatorService = new ValidatorService();

    public DrawCommand createCommand(Canvas canvas, String input) {
        validatorService.validateInput(input);
        String[] parameters = Arrays.stream(input.split(" "))
                .map(String::trim)
                .toArray(String[]::new);

        Character operation = parameters[0].charAt(0);
        switch (operation) {
            case 'C': {
                validatorService.validateParametersSize(parameters, 3);
                return new InitializeCanvasCommand(canvas, Integer.valueOf(parameters[1]),
                        Integer.valueOf(parameters[2]));
            }
            case 'L': {
                validatorService.validateParametersSize(parameters, 5);

                return new DrawLineCommand(canvas, Integer.valueOf(parameters[1]),
                        Integer.valueOf(parameters[2]), Integer.valueOf(parameters[3]),
                        Integer.valueOf(parameters[4]));
            }
            case 'R': {
                validatorService.validateParametersSize(parameters, 5);
                return new DrawRectangleCommand(canvas, Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]),
                        Integer.valueOf(parameters[3]), Integer.valueOf(parameters[4]));
            }
            case 'B': {
                validatorService.validateParametersSize(parameters, 4);
                return new FillAreaCommand(canvas, Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]),
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
}
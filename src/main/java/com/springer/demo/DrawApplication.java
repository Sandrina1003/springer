package com.springer.demo;

import com.springer.demo.canvas.Canvas;
import com.springer.demo.canvas.DrawingCanvas;
import com.springer.demo.command.DrawCommand;
import com.springer.demo.exeption.InvalidCommandException;
import com.springer.demo.factory.CommandFactory;

import java.util.Scanner;

public class DrawApplication {

    public static void main(String[] args) {
        Canvas canvas = new DrawingCanvas();
        CommandFactory commandFactory = new CommandFactory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("enter command: ");
            String inputCommand = input.nextLine();
            try {
                DrawCommand command = commandFactory.createCommand(canvas, inputCommand);
                command.execute();
            } catch (InvalidCommandException ex) {
                System.out.println(ex.getMessage());
            } finally {
                canvas.printCanvas();
            }
        }
    }
}

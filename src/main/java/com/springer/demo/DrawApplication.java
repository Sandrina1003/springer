package com.springer.demo;

import com.springer.demo.canvas.Canvas;
import com.springer.demo.canvas.CanvasInterface;
import com.springer.demo.command.DrawCommand;
import com.springer.demo.factory.CommandFactory;

import java.util.Scanner;

public class DrawApplication {

    public static void main(String[] args) {
        CanvasInterface canvas = new Canvas();
        CommandFactory commandFactory = new CommandFactory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("enter command: ");
            String inputCommand = input.nextLine();
            DrawCommand command = commandFactory.createCommand(canvas, inputCommand);
            command.execute();
            canvas.printCanvas();
        }
    }
}

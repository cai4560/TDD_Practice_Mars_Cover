package com.thoughtworks.command;

import com.thoughtworks.Rover;

public class PrintCommand implements Command {

    private final Rover rover;

    public PrintCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        System.out.println("Current Location: " + rover.executePrint());
    }
}

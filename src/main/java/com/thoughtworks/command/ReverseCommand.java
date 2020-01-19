package com.thoughtworks.command;

import com.thoughtworks.Rover;

public class ReverseCommand implements Command {

    private final Rover rover;

    public ReverseCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.executeReverse();
    }
}

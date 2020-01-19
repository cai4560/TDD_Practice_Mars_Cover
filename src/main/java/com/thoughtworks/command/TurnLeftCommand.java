package com.thoughtworks.command;

import com.thoughtworks.Rover;

public class TurnLeftCommand implements Command {

    private final Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.executeTurnLeft();
    }
}

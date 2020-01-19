package com.thoughtworks.command;

import com.thoughtworks.Rover;

public class TurnRightCommand implements Command {

    private final Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.executeTurnRight();
    }
}

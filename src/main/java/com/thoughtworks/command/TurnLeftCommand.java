package com.thoughtworks.command;

import com.thoughtworks.Context;

public class TurnLeftCommand extends Command {

    public TurnLeftCommand(Context context) {
        super(context);
    }

    @Override
    public void execute() {
        context.executeTurnLeft();
    }
}

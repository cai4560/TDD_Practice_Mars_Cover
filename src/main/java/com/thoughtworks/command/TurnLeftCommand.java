package com.thoughtworks.command;

import com.thoughtworks.Context;

public class TurnLeftCommand implements Command {

    private final Context context;

    public TurnLeftCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.executeTurnLeft();
    }
}

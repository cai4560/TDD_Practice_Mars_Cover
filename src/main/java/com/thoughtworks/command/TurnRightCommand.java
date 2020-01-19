package com.thoughtworks.command;

import com.thoughtworks.Context;

public class TurnRightCommand implements Command {

    private final Context context;

    public TurnRightCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.executeTurnRight();
    }
}

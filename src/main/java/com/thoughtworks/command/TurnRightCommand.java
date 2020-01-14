package com.thoughtworks.command;

import com.thoughtworks.Context;

public class TurnRightCommand extends Command {

    public TurnRightCommand(Context context) {
        super(context);
    }

    @Override
    public void execute() {
        context.executeTurnRight();
    }
}

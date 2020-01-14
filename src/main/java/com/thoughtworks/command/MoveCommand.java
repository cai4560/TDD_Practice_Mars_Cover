package com.thoughtworks.command;

import com.thoughtworks.Context;

public class MoveCommand extends Command {

    public MoveCommand(Context context) {
        super(context);
    }

    @Override
    public void execute() {
        context.executeMove();
    }
}

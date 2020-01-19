package com.thoughtworks.command;

import com.thoughtworks.Context;

public class MoveCommand implements Command {

    private final Context context;

    public MoveCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.executeMove();
    }
}

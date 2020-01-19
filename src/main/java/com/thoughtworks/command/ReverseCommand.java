package com.thoughtworks.command;

import com.thoughtworks.Context;

public class ReverseCommand implements Command {

    private final Context context;

    public ReverseCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.executeReverse();
    }
}

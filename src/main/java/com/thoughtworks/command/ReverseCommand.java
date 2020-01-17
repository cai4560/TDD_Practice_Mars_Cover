package com.thoughtworks.command;

import com.thoughtworks.Context;

public class ReverseCommand extends Command {

    public ReverseCommand(Context context) {
        super(context);
    }

    @Override
    public void execute() {
        context.executeReverse();
    }
}

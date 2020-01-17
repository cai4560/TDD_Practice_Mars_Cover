package com.thoughtworks.command;

import com.thoughtworks.Context;

public class PrintCommand extends Command {

    public PrintCommand(Context context) {
        super(context);
    }

    @Override
    public void execute() {
        System.out.println("Current Location: " + context.executePrint());
    }
}

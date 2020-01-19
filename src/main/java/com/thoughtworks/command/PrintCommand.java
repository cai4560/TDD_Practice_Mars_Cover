package com.thoughtworks.command;

import com.thoughtworks.Context;

public class PrintCommand implements Command {

    private final Context context;

    public PrintCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        System.out.println("Current Location: " + context.executePrint());
    }
}

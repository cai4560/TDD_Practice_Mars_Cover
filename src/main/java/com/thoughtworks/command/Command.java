package com.thoughtworks.command;

import com.thoughtworks.Context;

public abstract class Command {

    protected Context context;

    public Command(Context context) {
        this.context = context;
    }

    public abstract void execute();
}

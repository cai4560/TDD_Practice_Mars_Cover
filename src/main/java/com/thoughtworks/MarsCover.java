package com.thoughtworks;

import com.thoughtworks.command.Command;

import java.util.List;

public class MarsCover {

    private static CommandResolver commandResolver;

    public MarsCover() {
        commandResolver = new CommandResolver();
    }

    public static void main(String[] args) {
        String fileName = "inputs.txt";
        MarsCover marsCover = new MarsCover();
        marsCover.execute(fileName);
    }

    public void execute(String fileName) {
        List<Command> commandList = commandResolver.resolve(fileName);
        commandList.forEach(Command::execute);
    }
}

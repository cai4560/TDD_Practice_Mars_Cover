package com.thoughtworks;

import com.thoughtworks.command.Command;

import java.util.List;

public class MarsRover {

    private static CommandResolver commandResolver;

    public MarsRover() {
        commandResolver = new CommandResolver();
    }

    public static void main(String[] args) {
        String fileName = "inputs.txt";
        MarsRover marsRover = new MarsRover();
        marsRover.execute(fileName);
    }

    public void execute(String fileName) {
        List<Command> commandList = commandResolver.resolve(fileName);
        commandList.forEach(Command::execute);
    }
}

package com.thoughtworks;

import com.thoughtworks.command.Command;

import java.util.List;

public class MarsCover {

    public static void main(String[] args) {
        List<Command> commandList = new CommandResolver().resolve("inputs.txt");
        commandList.forEach(Command::execute);
    }
}

package com.thoughtworks;

import com.thoughtworks.command.*;
import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import com.thoughtworks.utils.FileLoader;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandResolver {

    public List<Command> resolve(String fileName) {
        List<String> inputs = FileLoader.loadFile(fileName);

        if (inputs.isEmpty()) {
            throw new RuntimeException("Missing input command");
        }

        String[] dimensions = inputs.get(0).split(" ");
        Location startLocation = new Location(Integer.valueOf(dimensions[0]), Integer.valueOf(dimensions[1]));
        Direction startDirection = Direction.parseFromValue(dimensions[2]);
        Context context = new Context(startLocation, startDirection);

        List<Command> commandList = inputs.subList(1, inputs.size()).stream()
                .map(input -> parseCommand(input, context))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        commandList.add(new PrintCommand(context));
        return commandList;
    }

    private Command parseCommand(String input, Context context) {
        switch (input) {
            case "P": return new PrintCommand(context);
            case "M": return new MoveCommand(context);
            case "L": return new TurnLeftCommand(context);
            case "R": return new TurnRightCommand(context);
            default: return null;
        }
    }
}

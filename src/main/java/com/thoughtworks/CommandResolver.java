package com.thoughtworks;

import com.thoughtworks.command.*;
import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import com.thoughtworks.utils.FileLoader;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandResolver {

    private static final Map<String, Function<Context, Command>> commandMap = Map.of(
            "P", PrintCommand::new,
            "M", MoveCommand::new,
            "L", TurnLeftCommand::new,
            "R", TurnRightCommand::new
    );

    public List<Command> resolve(String fileName) {
        List<String> inputs = FileLoader.loadFile(fileName);

        if (inputs.isEmpty()) {
            throw new RuntimeException("Missing input command");
        }

        Context context = resolveContext(inputs.get(0));

        List<Command> commandList = inputs.subList(1, inputs.size()).stream()
                .map(input -> resolveCommand(input, context))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        commandList.add(new PrintCommand(context));
        return commandList;
    }

    private Context resolveContext(String input) {
        String[] dimensions = input.split(" ");
        Location startLocation = new Location(Integer.valueOf(dimensions[0]), Integer.valueOf(dimensions[1]));
        Direction startDirection = Direction.parseFromValue(dimensions[2]);
        return new Context(startLocation, startDirection);
    }

    private Command resolveCommand(String input, Context context) {
        if (!commandMap.containsKey(input)) {
            throw new RuntimeException(String.format("Unknown Command: %s", input));
        }
        return commandMap.get(input).apply(context);
    }
}

package com.thoughtworks;

import com.thoughtworks.command.*;
import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import com.thoughtworks.utils.FileUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandResolver {

    private static final Pattern PATTERN = Pattern.compile("^(\\d+) (\\d+) ([A-Z])$");

    private static final Map<String, Function<Rover, Command>> COMMAND_MAP = Map.of(
            "P", PrintCommand::new,
            "M", MoveCommand::new,
            "L", TurnLeftCommand::new,
            "R", TurnRightCommand::new,
            "Reverse", ReverseCommand::new
    );

    public List<Command> resolve(String fileName) {
        List<String> inputs = FileUtil.loadFile(fileName);

        if (inputs.isEmpty()) {
            throw new RuntimeException("Missing input command");
        }
        Rover rover = resolveContext(inputs.get(0));

        List<Command> commandList = inputs.subList(1, inputs.size()).stream()
                .map(input -> resolveCommand(input, rover))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        commandList.add(new PrintCommand(rover));
        return commandList;
    }

    private Rover resolveContext(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            Location startLocation = new Location(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
            Direction startDirection = Direction.parseFromValue(matcher.group(3));
            return new Rover(startLocation, startDirection);
        } else {
            throw new RuntimeException("Unknown Start");
        }
    }

    private Command resolveCommand(String input, Rover rover) {
        if (!COMMAND_MAP.containsKey(input)) {
            throw new RuntimeException(String.format("Unknown Command: %s", input));
        }
        return COMMAND_MAP.get(input).apply(rover);
    }
}

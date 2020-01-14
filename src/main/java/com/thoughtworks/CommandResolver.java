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

    private static final Pattern pattern = Pattern.compile("^(\\d+) (\\d+) ([A-Z])$");

    private static final Map<String, Function<Context, Command>> commandMap = Map.of(
            "P", PrintCommand::new,
            "M", MoveCommand::new,
            "L", TurnLeftCommand::new,
            "R", TurnRightCommand::new
    );

    public List<Command> resolve(String fileName) {
        List<String> inputs = FileUtil.loadFile(fileName);

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
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            Location startLocation = new Location(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
            Direction startDirection = Direction.parseFromValue(matcher.group(3));
            return new Context(startLocation, startDirection);
        } else {
            throw new RuntimeException("Unknown Start");
        }
    }

    private Command resolveCommand(String input, Context context) {
        if (!commandMap.containsKey(input)) {
            throw new RuntimeException(String.format("Unknown Command: %s", input));
        }
        return commandMap.get(input).apply(context);
    }
}

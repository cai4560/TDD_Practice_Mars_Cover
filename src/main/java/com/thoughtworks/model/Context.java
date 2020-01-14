package com.thoughtworks.model;

import java.util.Map;
import java.util.function.Function;

public class Context {

    private static final Map<Direction, Function<Location, Location>> vectorMap = Map.of(
            Direction.North, loc -> new Location(loc.getX(), loc.getY() - 1),
            Direction.South, loc -> new Location(loc.getX(), loc.getY() + 1),
            Direction.West, loc -> new Location(loc.getX() - 1, loc.getY()),
            Direction.East, loc -> new Location(loc.getX() + 1, loc.getY())
    );

    private Location location;

    private Direction direction;

    public Context(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public void executeMove() {
        this.location = vectorMap.get(direction).apply(location);
    }

    public String executePrint() {
        return String.format("%s %s %s", location.getX(), location.getY(), direction.getValue());
    }

    public Location getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }
}

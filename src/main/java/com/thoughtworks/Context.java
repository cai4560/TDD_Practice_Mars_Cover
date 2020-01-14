package com.thoughtworks;

import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;

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

    public String executePrint() {
        return String.format("%s %s %s", location.getX(), location.getY(), direction.getValue());
    }

    public void executeMove() {
        this.location = vectorMap.get(direction).apply(location);
    }

    public void executeTurnLeft() {
        this.direction = direction.getLeftDirection();
    }

    public void executeTurnRight() {
        this.direction = direction.getRightDirection();
    }

    public Location getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }
}

package com.thoughtworks;

import com.thoughtworks.model.State;
import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public class Context {

    private static final Map<Direction, Function<Location, Location>> VECTOR_MAP = Map.of(
            Direction.North, loc -> new Location(loc.getX(), loc.getY() - 1),
            Direction.South, loc -> new Location(loc.getX(), loc.getY() + 1),
            Direction.West, loc -> new Location(loc.getX() - 1, loc.getY()),
            Direction.East, loc -> new Location(loc.getX() + 1, loc.getY())
    );

    private static final Map<Direction, Function<Location, Location>> REVERSED_VECTOR_MAP = Map.of(
            Direction.North, loc -> new Location(loc.getX(), loc.getY() + 1),
            Direction.South, loc -> new Location(loc.getX(), loc.getY() - 1),
            Direction.West, loc -> new Location(loc.getX() + 1, loc.getY()),
            Direction.East, loc -> new Location(loc.getX() - 1, loc.getY())
    );

    private Location location;

    private Direction direction;

    private State state;

    public Context(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
        this.state = State.NORMAL;
    }

    public String executePrint() {
        return String.format("%s %s %s", location.getX(), location.getY(), direction.getValue());
    }

    public void executeMove() {
        Map<Direction, Function<Location, Location>> vectorMap = state.equals(State.NORMAL)
                ? VECTOR_MAP : REVERSED_VECTOR_MAP;
        this.location = vectorMap.get(direction).apply(location);
    }

    public void executeTurnLeft() {
        this.direction = direction.getLeftDirection();
    }

    public void executeTurnRight() {
        this.direction = direction.getRightDirection();
    }
}

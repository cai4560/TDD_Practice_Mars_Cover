package com.thoughtworks.model;

public class Context {

    private Location location;

    private Direction direction;

    public Context(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public void executeMove() {
        Vector vector = getDirection().getVector();
        this.location = new Location(location.getX() + vector.getX(), location.getY() + vector.getY());
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

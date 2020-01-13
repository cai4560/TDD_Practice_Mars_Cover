package com.thoughtworks.model;

public class Context {

    private Location location;

    private Direction direction;

    public Context(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", location.getX(), location.getY(), direction.getValue());
    }

    public void executeMove() {
        Vector vector = getDirection().getVector();
        this.location = new Location(getLocation().getX() + vector.getX(), getLocation().getY() + vector.getY());
    }

    private Location getLocation() {
        return location;
    }

    private Direction getDirection() {
        return direction;
    }
}

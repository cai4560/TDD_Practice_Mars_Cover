package com.thoughtworks.model;

public enum Direction {
    North("N", new Vector(0, -1)),
    South("S", new Vector(0, 1)),
    West("W", new Vector(-1, 0)),
    East("E", new Vector(1, 0));

    private String value;

    private Vector vector;

    Direction(String value, Vector vector) {
        this.value = value;
        this.vector = vector;
    }

    public String getValue() {
        return value;
    }

    public Vector getVector() {
        return vector;
    }
}

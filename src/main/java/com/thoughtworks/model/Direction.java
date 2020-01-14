package com.thoughtworks.model;

public enum Direction {
    North("N"),
    South("S"),
    West("W"),
    East("E");

    private String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

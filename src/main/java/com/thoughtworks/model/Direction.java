package com.thoughtworks.model;

import java.util.Arrays;

public enum Direction {
    North(0, "N"),
    East(1, "E"),
    South(2, "S"),
    West(3, "W");

    private int index;

    private String value;

    Direction(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Direction getLeftDirection() {
        return getDirectionByIndex((index + 3) % 4);
    }

    public Direction getRightDirection() {
        return getDirectionByIndex((index + 1) % 4);
    }

    private Direction getDirectionByIndex(int index) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.index == index)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

package com.thoughtworks.model;

import java.util.Arrays;
import java.util.function.Predicate;

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
        return parseFromIndex((index + 3) % 4);
    }

    public Direction getRightDirection() {
        return parseFromIndex((index + 1) % 4);
    }

    public static Direction parseFromValue(String value) {
        return parseDirection(valueEqual(value));
    }

    private static Direction parseFromIndex(int index) {
        return parseDirection(indexEqual(index));
    }

    private static Direction parseDirection(Predicate<Direction> predicate) {
        return Arrays.stream(Direction.values())
                .filter(predicate)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private static Predicate<Direction> indexEqual(int index) {
        return direction -> direction.index == index;
    }

    private static Predicate<Direction> valueEqual(String value) {
        return direction -> direction.value.equals(value);
    }
}

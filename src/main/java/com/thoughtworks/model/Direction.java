package com.thoughtworks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public enum Direction {
    North(0, "N"),
    East(1, "E"),
    South(2, "S"),
    West(3, "W");

    private int index;

    private String value;

    public Direction getLeftDirection(State state) {
        return parseFromIndex(state.isNormal() ? getLeftDirectionIndex() : getRightDirectionIndex());
    }

    public Direction getRightDirection(State state) {
        return parseFromIndex(state.isNormal() ? getRightDirectionIndex() : getLeftDirectionIndex());
    }

    private int getLeftDirectionIndex() {
        return (this.index + 3) % 4;
    }

    private int getRightDirectionIndex() {
        return (this.index + 1) % 4;
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

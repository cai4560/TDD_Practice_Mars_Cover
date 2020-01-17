package com.thoughtworks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Vector {

    private static final Map<Direction, Vector> VECTOR_MAP = Map.of(
            Direction.North, new Vector(0, -1),
            Direction.South, new Vector(0, 1),
            Direction.West, new Vector(-1, 0),
            Direction.East, new Vector(1, 0)
    );

    private Integer x;

    private Integer y;

    private Vector reverse() {
        return new Vector(x * -1, y * -1);
    }

    public static Vector getVectorBy(Direction direction, State state) {
        Vector vector = VECTOR_MAP.get(direction);
        return state.isNormal() ? vector : vector.reverse();
    }
}

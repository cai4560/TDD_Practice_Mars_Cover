package com.thoughtworks.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DirectionTest {

    @Test
    public void should_get_left_direction() {
        assertThat(Direction.North.getLeftDirection()).isEqualTo(Direction.West);
        assertThat(Direction.East.getLeftDirection()).isEqualTo(Direction.North);
        assertThat(Direction.South.getLeftDirection()).isEqualTo(Direction.East);
        assertThat(Direction.West.getLeftDirection()).isEqualTo(Direction.South);
    }

    @Test
    public void should_get_right_direction() {
        assertThat(Direction.North.getRightDirection()).isEqualTo(Direction.East);
        assertThat(Direction.East.getRightDirection()).isEqualTo(Direction.South);
        assertThat(Direction.South.getRightDirection()).isEqualTo(Direction.West);
        assertThat(Direction.West.getRightDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void should_parse_direction_from_value() {
        assertThat(Direction.parseFromValue("N")).isEqualTo(Direction.North);
        assertThat(Direction.parseFromValue("E")).isEqualTo(Direction.East);
        assertThat(Direction.parseFromValue("S")).isEqualTo(Direction.South);
        assertThat(Direction.parseFromValue("W")).isEqualTo(Direction.West);
    }

    @Test
    public void should_throw_exception_when_parse_invalid_direction() {
        assertThrows(RuntimeException.class, () -> Direction.parseFromValue("Invalid"));
    }
}
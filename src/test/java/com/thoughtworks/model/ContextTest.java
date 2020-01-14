package com.thoughtworks.model;

import com.thoughtworks.Context;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextTest {

    @Test
    public void should_print_context_with_format() {
        Context context = new Context(new Location(5, 5), Direction.West);
        assertThat(context.executePrint()).isEqualTo("5 5 W");
    }

    @Test
    public void should_move_forward_with_direction_west() {
        Context context = new Context(new Location(5, 5), Direction.West);
        context.executeMove();
        assertThat(context.getLocation().getX()).isEqualTo(4);
        assertThat(context.getLocation().getY()).isEqualTo(5);
        assertThat(context.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void should_move_forward_with_direction_east() {
        Context context = new Context(new Location(5, 5), Direction.East);
        context.executeMove();
        assertThat(context.getLocation().getX()).isEqualTo(6);
        assertThat(context.getLocation().getY()).isEqualTo(5);
        assertThat(context.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void should_move_forward_with_direction_south() {
        Context context = new Context(new Location(5, 5), Direction.South);
        context.executeMove();
        assertThat(context.getLocation().getX()).isEqualTo(5);
        assertThat(context.getLocation().getY()).isEqualTo(6);
        assertThat(context.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    public void should_move_forward_with_direction_north() {
        Context context = new Context(new Location(5, 5), Direction.North);
        context.executeMove();
        assertThat(context.getLocation().getX()).isEqualTo(5);
        assertThat(context.getLocation().getY()).isEqualTo(4);
        assertThat(context.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void should_turn_left_with_direction_north() {
        Context context = new Context(new Location(5, 5), Direction.North);
        context.executeTurnLeft();
        assertThat(context.getLocation().getX()).isEqualTo(5);
        assertThat(context.getLocation().getY()).isEqualTo(5);
        assertThat(context.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void should_turn_right_with_direction_south() {
        Context context = new Context(new Location(5, 5), Direction.North);
        context.executeTurnRight();
        assertThat(context.getLocation().getX()).isEqualTo(5);
        assertThat(context.getLocation().getY()).isEqualTo(5);
        assertThat(context.getDirection()).isEqualTo(Direction.East);
    }
}
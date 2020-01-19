package com.thoughtworks;

import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import com.thoughtworks.model.State;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_print_context_with_format() {
        Rover rover = new Rover(new Location(5, 5), Direction.West);
        assertThat(rover.executePrint()).isEqualTo("5 5 W");
    }

    @Test
    public void should_move_forward_with_direction_west() {
        Rover rover = new Rover(new Location(5, 5), Direction.West);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(4);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void should_move_forward_with_direction_east() {
        Rover rover = new Rover(new Location(5, 5), Direction.East);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(6);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void should_move_forward_with_direction_south() {
        Rover rover = new Rover(new Location(5, 5), Direction.South);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(6);
        assertThat(rover.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    public void should_move_forward_with_direction_north() {
        Rover rover = new Rover(new Location(5, 5), Direction.North);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void should_turn_left_with_direction_north() {
        Rover rover = new Rover(new Location(5, 5), Direction.North);
        rover.executeTurnLeft();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void should_turn_right_with_direction_south() {
        Rover rover = new Rover(new Location(5, 5), Direction.North);
        rover.executeTurnRight();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void should_move_back_with_direction_west_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.West, State.REVERSED);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(6);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void should_move_back_with_direction_east_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.East, State.REVERSED);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(4);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void should_move_back_with_direction_south_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.South, State.REVERSED);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    public void should_move_back_with_direction_north_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.North, State.REVERSED);
        rover.executeMove();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(6);
        assertThat(rover.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void should_turn_left_with_direction_north_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.North, State.REVERSED);
        rover.executeTurnLeft();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void should_turn_right_with_direction_south_when_state_reverse() {
        Rover rover = new Rover(new Location(5, 5), Direction.North, State.REVERSED);
        rover.executeTurnRight();
        assertThat(rover.getLocation().getX()).isEqualTo(5);
        assertThat(rover.getLocation().getY()).isEqualTo(5);
        assertThat(rover.getDirection()).isEqualTo(Direction.West);
    }
}
package com.thoughtworks;

import com.thoughtworks.model.Context;
import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsCoverTest {

    @Test
    public void should_move_forward_with_direction_west() {
        MarsCover marsCover = new MarsCover(new Context(new Location(5, 5), Direction.West));
        marsCover.move();
        assertThat(marsCover.getContext().toString()).isEqualTo("4 5 W");
    }

    @Test
    public void should_move_forward_with_direction_east() {
        MarsCover marsCover = new MarsCover(new Context(new Location(5, 5), Direction.East));
        marsCover.move();
        assertThat(marsCover.getContext().toString()).isEqualTo("6 5 E");
    }

    @Test
    public void should_move_forward_with_direction_south() {
        MarsCover marsCover = new MarsCover(new Context(new Location(5, 5), Direction.South));
        marsCover.move();
        assertThat(marsCover.getContext().toString()).isEqualTo("5 6 S");
    }

    @Test
    public void should_move_forward_with_direction_north() {
        MarsCover marsCover = new MarsCover(new Context(new Location(5, 5), Direction.North));
        marsCover.move();
        assertThat(marsCover.getContext().toString()).isEqualTo("5 4 N");
    }
}
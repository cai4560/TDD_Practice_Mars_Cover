package com.thoughtworks;

import com.thoughtworks.model.Direction;
import com.thoughtworks.model.Location;
import com.thoughtworks.model.State;
import com.thoughtworks.model.Vector;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.thoughtworks.model.Vector.getVectorBy;

@Getter
@AllArgsConstructor
public class Rover {

    private Location location;

    private Direction direction;

    private State state;

    public Rover(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
        this.state = State.NORMAL;
    }

    public String executePrint() {
        return String.format("%s %s %s", location.getX(), location.getY(), direction.getValue());
    }

    public void executeMove() {
        Vector vector = getVectorBy(direction, state);
        this.location.addVector(vector);
    }

    public void executeTurnLeft() {
        this.direction = direction.getLeftDirection(state);
    }

    public void executeTurnRight() {
        this.direction = direction.getRightDirection(state);
    }

    public void executeReverse() {
        this.state = this.state.reverse();
    }
}

package com.thoughtworks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {

    private Integer x;

    private Integer y;

    public void addVector(Vector vector) {
        this.x = x + vector.getX();
        this.y = y + vector.getY();
    }
}

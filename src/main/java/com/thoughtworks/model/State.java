package com.thoughtworks.model;

public enum State {
    NORMAL,
    REVERSED;

    public boolean isNormal() {
        return this.equals(NORMAL);
    }

    public State reverse() {
        return this.isNormal() ? REVERSED : NORMAL;
    }
}

package com.thoughtworks.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Test
    public void should_reverse_state() {
        assertThat(State.NORMAL.reverse()).isEqualTo(State.REVERSED);
        assertThat(State.REVERSED.reverse()).isEqualTo(State.NORMAL);
    }
}
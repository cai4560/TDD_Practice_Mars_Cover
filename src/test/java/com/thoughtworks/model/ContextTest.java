package com.thoughtworks.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContextTest {

    @Test
    public void should_print_context_with_format() {
      Context context = new Context(new Location(5, 5), Direction.West);
      assertThat(context.toString()).isEqualTo("5 5 W");
    }
}
package com.thoughtworks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


public class MarsRoverTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private MarsRover marsRover;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        marsRover = new MarsRover();
    }

    @Test
    public void should_print_result_from_input_of_basic_requirement() {
        marsRover.execute("inputs.txt");
        assertThat(outContent.toString()).isEqualTo("Current Location: 3 1 N\n");
    }

    @Test
    public void should_print_result_from_input_of_new_requirement_1() {
        marsRover.execute("inputs2.txt");
        assertThat(outContent.toString()).isEqualTo("Current Location: 3 1 N\n"
                + "Current Location: 5 5 N\n");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setOut(originalErr);
    }
}
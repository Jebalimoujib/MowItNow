package com.mowitnow.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position positionUnderTest;

    @BeforeEach
    void setUp() {
        positionUnderTest = new Position(0, 0, Direction.N);
    }

    @Test
    void testMove() {
        // Setup
        final Pelouse pelouse = Pelouse.builder()
                .x(0)
                .y(0)
                .build();
        final Position expectedResult = Position.builder()
                .x(0)
                .y(0)
                .direction(Direction.N)
                .build();

        // Run the test
        final Position result = positionUnderTest.move(pelouse);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testChangeDirection() {
        // Setup
        final Position expectedResult = Position.builder()
                .x(0)
                .y(0)
                .direction(Direction.E)
                .build();

        // Run the test
        final Position result = positionUnderTest.changeDirection(Instruction.D);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}

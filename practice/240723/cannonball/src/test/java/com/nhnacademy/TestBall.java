package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class TestBall {
    @Test
    void testCreation() {
        assertDoesNotThrow(() -> {
            int x = 10;
            int y = 10;
            int radius = 20;

            Ball ball = new Ball(x, y, radius);

            assertEquals(x, ball.getX());
            assertEquals(y, ball.getY());
            assertEquals(radius, ball.getRadius());
        });
    }

    @Test
    void testIllegalRadius() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            int x = 10;
            int y = 10;
            int radius = -1;

            new Ball(x, y, radius);
        });
    }
}

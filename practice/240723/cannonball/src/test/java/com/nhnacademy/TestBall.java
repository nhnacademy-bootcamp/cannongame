package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;

public class TestBall {
    Random random = new Random();

    @RepeatedTest(1000)
    void testCreation() {
        assertDoesNotThrow(() -> {
            int radius = random.nextInt(Integer.MAX_VALUE / 2);
            int gap = Integer.MAX_VALUE - radius;
            int x = random.nextInt(gap) * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);
            int y = random.nextInt(gap) * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);

            Ball ball = new Ball(x, y, radius);

            assertEquals(x, ball.getRegion().getCenterX());
            assertEquals(y, ball.getRegion().getCenterY());
            assertEquals(radius, ball.getRadius());
        });
    }

    @RepeatedTest(1000)
    void testIllegalRadius() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            int radius = random.nextInt(Integer.MAX_VALUE / 2);
            int gap = Integer.MAX_VALUE - radius;
            int x = random.nextInt(gap) * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);
            int y = random.nextInt(gap) * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);

            new Ball(x, y, -1 * radius);
            new Ball(Integer.MAX_VALUE - radius, y, radius);
            new Ball(x, Integer.MAX_VALUE - radius, radius);
            new Ball(Integer.MAX_VALUE - radius, Integer.MAX_VALUE - radius, radius);
        });
    }
}

package com.nhnacademy.exam030102;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.exam030101.MovableBall;

class TestMovableBall {
    static Random random = new Random();

    @RepeatedTest(10)
    void testMove() {
        int radius = 10 + random.nextInt(41);
        int x = random.nextInt(Integer.MAX_VALUE - radius);
        int y = random.nextInt(Integer.MAX_VALUE - radius);
        int dx = random.nextInt(100);
        int dy = random.nextInt(100);

        MovableBall ball = new MovableBall(x, y, radius);
        ball.setDX(dx);
        ball.setDY(dy);

        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());
        assertEquals(radius, ball.getRadius());
        assertEquals(dx, ball.getDX());
        assertEquals(dy, ball.getDY());

        for (int i = 0; i < 100; i++) {
            ball.move();

            x += dx;
            y += dy;

            assertEquals(x, ball.getX());
            assertEquals(y, ball.getY());
        }
    }

    @ParameterizedTest
    @MethodSource("moveProvider")
    void testParameterizedMove(int x, int y, int radius, int dx, int dy) {
        MovableBall ball = new MovableBall(x, y, radius);
        ball.setDX(dx);
        ball.setDY(dy);

        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());
        assertEquals(radius, ball.getRadius());
        assertEquals(dx, ball.getDX());
        assertEquals(dy, ball.getDY());

        for (int i = 0; i < 100; i++) {
            ball.move();

            x += dx;
            y += dy;

            assertEquals(x, ball.getX());
            assertEquals(y, ball.getY());
        }
    }

    static Stream<Arguments> moveProvider() {
        return Stream.of(
                Arguments.arguments(10, 10, 10, 10, 10),
                Arguments.arguments(10, 10, 10, -10, 10),
                Arguments.arguments(10, 20, 30, 40, 50));
    }
}

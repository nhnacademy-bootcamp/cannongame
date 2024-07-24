package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestMovableBall {
    @ParameterizedTest
    @MethodSource("testMovableBallProvider")
    void testMovableBall(int startX, int startY, int dx, int dy, int step) {
        MovableBall ball = new MovableBall(startX, startY, 10);

        ball.setDX(dx);
        ball.setDY(dy);

        for (int i = 0; i < step; i++) {
            ball.move();
        }

        assertEquals(dx, ball.getDX());
        assertEquals(dy, ball.getDY());
        assertEquals(startX + dx * step, ball.getRegion().getCenterX());
        assertEquals(startY + dy * step, ball.getRegion().getCenterY());
    }

    static Stream<Arguments> testMovableBallProvider() {
        return Stream.of(
                Arguments.of(0, 0, 4, 5, 5),
                Arguments.of(0, 0, -4, 5, 5));
    }
}

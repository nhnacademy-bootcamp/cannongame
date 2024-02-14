package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestVector {
    @Test
    void testConstructor() {
        int x = 10;
        int y = 100;

        assertDoesNotThrow(() -> {
            Vector vector = new PositionalVector(x, y);

            assertEquals(x, vector.getDX());
            assertEquals(y, vector.getDY());
        });
    }

    @ParameterizedTest
    @MethodSource("testDisplacementProvider")
    void testDisplacement(int x, int y, int magnitude, int angle) {
        assertDoesNotThrow(() -> {
            Vector vector = new PositionalVector(x, y);

            assertEquals(x, vector.getDX());
            assertEquals(y, vector.getDY());
            assertEquals(angle, vector.getAngle());
            assertEquals(magnitude, vector.getMagnitude());
        });
    }

    static Stream<Arguments> testDisplacementProvider() {
        return Stream.of(
                Arguments.arguments(10, 0, 10, 0),
                Arguments.arguments(0, 10, 10, 90),
                Arguments.arguments(-10, 0, 10, 180),
                Arguments.arguments(0, -10, 10, -90));
    }

    @Test
    void testAdd() {
        Vector vector1 = new PositionalVector(10, 20);
        Vector vector2 = new PositionalVector(20, 5);
        Vector target = new PositionalVector(30, 25);

        vector1.add(vector2);
        assertEquals(target, vector1);
    }
}

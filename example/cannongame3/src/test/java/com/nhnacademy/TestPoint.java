package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TestPoint {
    static Random random = new Random();

    @Test
    void testConstructor() {
        int x = 10;
        int y = 20;

        assertDoesNotThrow(() -> {
            Point point = new Point(x, y);

            assertEquals(x, point.getX());
            assertEquals(y, point.getY());
        });
    }

    @RepeatedTest(100)
    void testRepeatedConstructor() {
        int x = random.nextInt();
        int y = random.nextInt();

        assertDoesNotThrow(() -> {
            Point point = new Point(x, y);

            assertEquals(x, point.getX());
            assertEquals(y, point.getY());
        });
    }

    @Test
    void testCopyConstructor() {
        Point base = new Point(10, 20);
        assertDoesNotThrow(() -> {
            Point point = new Point(base);

            assertEquals(base, point);
        });
    }

    @Test
    void testEquals() {
        int x = 10;
        int y = 20;
        Point point1 = new Point(x, y);
        Point point2 = new Point(x, y);
        Point point3 = new Point(x, x);

        assertEquals(point1, point2);
        assertNotEquals(point1, point3);
    }

    @Test
    void testOverflow() {
        Point point = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);

        assertThrowsExactly(OutOfBoundsException.class, () -> {
            point.translate(1, 0);
        });
    }

    @Test
    void testToString() {
        Point point = new Point(10, 10);

        assertEquals("(10,10)", point.toString());
    }
}

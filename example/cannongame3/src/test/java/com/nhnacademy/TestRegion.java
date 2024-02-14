package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

class TestRegion {
    @Test
    void testConstructor() {
        Point location = new Point(10, 10);
        int width = 100;
        int height = 50;

        assertDoesNotThrow(() -> {
            Region region = new Region(location, width, height);

            assertEquals(location, region.getLocation());
            assertEquals(width, region.getWidth());
            assertEquals(height, region.getHeight());
        });
    }

    @Test
    void testIntersection() {
        Region region1 = new Region(new Point(100, 100), 100, 80);
        Region region2 = new Region(new Point(50, 50), 60, 40);

        Region target = new Region(new Point(65, 65), 30, 10);

        Region region3 = region1.intersection(region2);

        assertEquals(target, region3);
    }

    @Test
    void testOutOfBoundsException() {
        Region region1 = new Region(new Point(Integer.MAX_VALUE - 100, 100), 100, 80);

        assertDoesNotThrow(() -> {
            region1.translate(-200, 0);
        });

        assertThrowsExactly(OutOfBoundsException.class, () -> {
            region1.translate(400, 0);
        });
    }
}

package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestRegion {
    Random random = new Random();

    @RepeatedTest(100)
    void testConstructor() {
        assertDoesNotThrow(() -> {
            int width = random.nextInt(Integer.MAX_VALUE / 2);
            int height = random.nextInt(Integer.MAX_VALUE / 2);
            Dimension dimension = new Dimension(width, height);
            int x = random.nextInt(Integer.MAX_VALUE - width) * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);
            int y = random.nextInt(Integer.MAX_VALUE - height)
                    * ((random.nextInt(Integer.MAX_VALUE) % 2 == 0) ? -1 : 1);
            Location location = new Location(x, y);

            Region region1 = new Region(x, y, width, height);
            Region region2 = new Region(location, width, height);
            Region region3 = new Region(location, dimension);

            assertEquals(x, region1.getCenterX());
            assertEquals(y, region1.getCenterY());
            assertEquals(x - width / 2, region1.getMinX());
            assertEquals(x + width / 2, region1.getMaxX());
            assertEquals(y - height / 2, region1.getMinY());
            assertEquals(y + height / 2, region1.getMaxY());
            assertEquals(width, region1.getWidth());
            assertEquals(height, region1.getHeight());
            assertEquals(location, region1.getLocation());
            assertEquals(dimension, region1.getDimension());
            assertEquals(region1, region2);
            assertEquals(region1, region3);
        });
    }

    @ParameterizedTest
    @MethodSource("testConstructorProvider")
    void testConstructor(int x, int y, int width, int height, int minX, int maxX, int minY, int maxY) {
        assertDoesNotThrow(() -> {
            Dimension dimension = new Dimension(width, height);
            Location location = new Location(x, y);

            Region region1 = new Region(x, y, width, height);
            Region region2 = new Region(location, width, height);
            Region region3 = new Region(location, dimension);

            assertEquals(x, region1.getCenterX());
            assertEquals(y, region1.getCenterY());
            assertEquals(x - width / 2, region1.getMinX());
            assertEquals(x + width / 2, region1.getMaxX());
            assertEquals(y - height / 2, region1.getMinY());
            assertEquals(y + height / 2, region1.getMaxY());
            assertEquals(width, region1.getWidth());
            assertEquals(height, region1.getHeight());
            assertEquals(location, region1.getLocation());
            assertEquals(dimension, region1.getDimension());
            assertEquals(region1, region2);
            assertEquals(region1, region3);
        });
    }

    static Stream<Arguments> testConstructorProvider() {
        return Stream.of(
                Arguments.of(0, 0, 100, 100, -50, 50, -50, 50),
                Arguments.of(0, 100, 100, 100, -50, 50, 0, 100));
    }
}

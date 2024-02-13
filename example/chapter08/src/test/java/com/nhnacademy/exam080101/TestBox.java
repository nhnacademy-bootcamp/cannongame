package com.nhnacademy.exam080101;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.exam080201.Box;
import com.nhnacademy.exam080201.Point;

public class TestBox {
    @ParameterizedTest
    @MethodSource("boxConstructionProvider")
    public void testBoxConstructor(int x, int y, int width, int height) {
        Box box = new Box(new Point(x, y), width, height);

        assertEquals(x, (int) box.getLocation().getX());
        assertEquals(y, (int) box.getLocation().getY());
        assertEquals(width, (int) box.getWidth());
        assertEquals(height, (int) box.getHeight());
    }

    public static Stream<Arguments> boxConstructionProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 20, 20),
                Arguments.arguments(0, 20, 20, 20),
                Arguments.arguments(20, 0, 20, 20),
                Arguments.arguments(20, 20, 20, 20),
                Arguments.arguments(0, 0, 20, 20),
                Arguments.arguments(0, -20, 20, 20),
                Arguments.arguments(-20, 0, 20, 20),
                Arguments.arguments(-20, -20, 20, 20));
    }
}

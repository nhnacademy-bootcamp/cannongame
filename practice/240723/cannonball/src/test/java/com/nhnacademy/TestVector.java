package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;

public class TestVector {
    Random random = new Random();

    @RepeatedTest(1000)
    void testConstructor() {
        assertDoesNotThrow(() -> {
            int dx = random.nextInt();
            int dy = random.nextInt();

            Vector vector = new PositionalVector(dx, dy);

            assertEquals(dx, vector.getDX());
            assertEquals(dy, vector.getDY());
        });
    }

    @RepeatedTest(1000)
    void testCopyConstructor() {
        assertDoesNotThrow(() -> {
            int dx = random.nextInt();
            int dy = random.nextInt();

            Vector originalVector = new PositionalVector(dx, dy);
            Vector copiedVector = new Vector(originalVector);

            assertEquals(dx, copiedVector.getDX());
            assertEquals(dy, copiedVector.getDY());
        });
    }

    @RepeatedTest(1000)
    void testAdd() {
        assertDoesNotThrow(() -> {
            int dx1 = random.nextInt();
            int dy1 = random.nextInt();
            int dx2 = random.nextInt();
            int dy2 = random.nextInt();

            Vector vector1 = new PositionalVector(dx1, dy1);
            Vector vector2 = new PositionalVector(dx2, dy2);

            vector1.add(vector2);

            assertEquals(dx1 + dx2, vector1.getDX());
            assertEquals(dy1 + dy2, vector1.getDY());
        });
    }

    @RepeatedTest(1000)
    void testSub() {
        assertDoesNotThrow(() -> {
            int dx1 = random.nextInt();
            int dy1 = random.nextInt();
            int dx2 = random.nextInt();
            int dy2 = random.nextInt();

            Vector vector1 = new PositionalVector(dx1, dy1);
            Vector vector2 = new PositionalVector(dx2, dy2);

            vector1.sub(vector2);

            assertEquals(dx1 - dx2, vector1.getDX());
            assertEquals(dy1 - dy2, vector1.getDY());
        });
    }

    @RepeatedTest(1000)
    void testStaticAdd() {
        assertDoesNotThrow(() -> {
            int dx1 = random.nextInt();
            int dy1 = random.nextInt();
            int dx2 = random.nextInt();
            int dy2 = random.nextInt();

            Vector vector1 = new PositionalVector(dx1, dy1);
            Vector vector2 = new PositionalVector(dx2, dy2);

            Vector result = Vector.add(vector1, vector2);

            assertEquals(dx1 + dx2, result.getDX());
            assertEquals(dy1 + dy2, result.getDY());
        });
    }

    @RepeatedTest(1000)
    void testStaticSub() {
        assertDoesNotThrow(() -> {
            int dx1 = random.nextInt();
            int dy1 = random.nextInt();
            int dx2 = random.nextInt();
            int dy2 = random.nextInt();

            Vector vector1 = new PositionalVector(dx1, dy1);
            Vector vector2 = new PositionalVector(dx2, dy2);

            Vector result = Vector.sub(vector1, vector2);

            assertEquals(dx1 - dx2, result.getDX());
            assertEquals(dy1 - dy2, result.getDY());
        });
    }
}

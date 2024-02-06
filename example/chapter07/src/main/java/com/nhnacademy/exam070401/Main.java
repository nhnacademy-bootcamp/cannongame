package com.nhnacademy.exam070401;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        final int MIN_RADIUS = 10;
        final int MAX_RADIUS = 50;
        final int MIN_WIDTH = 10;
        final int MAX_WIDTH = 50;
        final int MIN_HEIGHT = 10;
        final int MAX_HEIGHT = 50;
        final int MIN_DELTA = 3;
        final int MAX_DELTA = 10;
        final int WORLD_WIDTH = 400;
        final int WORLD_HEIGHT = 300;
        final int BALL_COUNT = 1;
        final int BOX_COUNT = 1;
        final int TRIANGLE_COUNT = 1;
        final int MAX_MOVE_COUNT = 0;
        final int DELTA_TIME = 10;

        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BoundedWorld world = new BoundedWorld();
        world.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.add(world);

        while (world.getCount() < BALL_COUNT) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = radius + random.nextInt(WORLD_WIDTH - 2 * radius);
            int y = radius + random.nextInt(WORLD_HEIGHT - 2 * radius);
            MovableBall ball = new MovableBall(new Point(x, y), radius);
            int dx = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);
            int dy = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);

            String sequence = "00" + (world.getCount() + 1);
            ball.setName("ball_" + sequence.substring(sequence.length() - 2));
            ball.setMotion(Motion.createPosition(dx, dy));

            try {
                world.add(ball);
            } catch (IllegalArgumentException ignore) {
                //
            }
        }

        while (world.getCount() < BALL_COUNT + BOX_COUNT) {
            int width = MIN_WIDTH + random.nextInt(MAX_WIDTH - MIN_WIDTH + 1);
            int height = MIN_HEIGHT + random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1);
            int x = width / 2 + random.nextInt(WORLD_WIDTH - width);
            int y = height / 2 + random.nextInt(WORLD_HEIGHT - height);
            MovableBox box = new MovableBox(new Point(x, y), width, height);
            int dx = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);
            int dy = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);

            String sequence = "00" + (world.getCount() + 1);
            box.setName("box_" + sequence.substring(sequence.length() - 2));
            box.setMotion(Motion.createPosition(dx, dy));

            try {
                world.add(box);
            } catch (IllegalArgumentException ignore) {
                //
            }
        }

        while (world.getCount() < BALL_COUNT + BOX_COUNT + TRIANGLE_COUNT) {
            int width = MIN_WIDTH + random.nextInt(MAX_WIDTH - MIN_WIDTH + 1);
            int height = MIN_HEIGHT + random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1);
            int x = width / 2 + random.nextInt(WORLD_WIDTH - width);
            int y = height / 2 + random.nextInt(WORLD_HEIGHT - height);
            MovableTriangle triangle = new MovableTriangle(new Point(x, y), width, height);
            int dx = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);
            int dy = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);

            String sequence = "00" + (world.getCount() + 1);
            triangle.setName("triangle_" + sequence.substring(sequence.length() - 2));
            triangle.setMotion(Motion.createPosition(dx, dy));

            try {
                world.add(triangle);
            } catch (IllegalArgumentException ignore) {
                //
            }
        }

        frame.setVisible(true);
        frame.setEnabled(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }
}

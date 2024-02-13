package com.nhnacademy.exam090201;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        final float WORLD_SCALE = 10.0f;
        final int MIN_RADIUS = (int) (40 * WORLD_SCALE);
        final int MAX_RADIUS = (int) (50 * WORLD_SCALE);
        final int MIN_WIDTH = (int) (40 * WORLD_SCALE);
        final int MAX_WIDTH = (int) (50 * WORLD_SCALE);
        final int MIN_HEIGHT = (int) (40 * WORLD_SCALE);
        final int MAX_HEIGHT = (int) (50 * WORLD_SCALE);
        final int MIN_DELTA = (int) (3 * WORLD_SCALE);
        final int MAX_DELTA = (int) (10 * WORLD_SCALE);
        final int WORLD_WIDTH = (int) (800 * WORLD_SCALE);
        final int WORLD_HEIGHT = (int) (600 * WORLD_SCALE);
        final int BALL_COUNT = 1;
        final int BOX_COUNT = 0;
        final int TRIANGLE_COUNT = 0;
        final int MAX_MOVE_COUNT = 0;
        final int DELTA_TIME = 20;

        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize((int) (WORLD_WIDTH / WORLD_SCALE), (int) (WORLD_HEIGHT / WORLD_SCALE));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BoundedWorld world = new BoundedWorld();
        world.setSize((int) (WORLD_WIDTH / WORLD_SCALE), (int) (WORLD_HEIGHT / WORLD_SCALE));
        world.setScale(WORLD_SCALE);
        world.setVirtualSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.add(world);

        while (world.getCount() < BALL_COUNT) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = WORLD_WIDTH / 2;// radius + random.nextInt(WORLD_WIDTH - 2 * radius);
            int y = WORLD_HEIGHT / 2; // radius + random.nextInt(WORLD_HEIGHT - 2 * radius);
            BoundedBall ball = new BoundedBall(new Point(x, y), radius);
            ball.setCOR(1.0);
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

        PaintableBox bottonWall = new PaintableBox(new Point(WORLD_WIDTH / 2, 50 - 500),
                WORLD_WIDTH * 2, 100 + 1000);
        PaintableBox topWall = new PaintableBox(new Point(WORLD_WIDTH / 2, WORLD_HEIGHT - 50 + 500),
                WORLD_WIDTH * 2, 100 + 1000);
        PaintableBox rightWall = new PaintableBox(new Point((WORLD_WIDTH - 50) + 500, WORLD_HEIGHT / 2),
                100 + 1000, WORLD_HEIGHT * 2);
        PaintableBox leftWall = new PaintableBox(new Point(50 - 500, WORLD_HEIGHT / 2),
                100 + 1000, WORLD_HEIGHT * 2);
        bottonWall.setCOR(0.7);
        topWall.setCOR(0.9);
        rightWall.setCOR(1.2);
        leftWall.setCOR(1.2);

        world.addHazard(bottonWall);
        world.addHazard(topWall);
        world.addHazard(rightWall);
        world.addHazard(leftWall);

        frame.setVisible(true);
        frame.setEnabled(true);

        world.addEffect(new Motion(0, -2));
        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }
}

package com.nhnacademy.exam040302;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        final int MIN_RADIUS = 10;
        final int MAX_RADIUS = 50;
        final int MIN_DELTA = 10;
        final int MAX_DELTA = 30;
        final int WORLD_WIDTH = 400;
        final int WORLD_HEIGHT = 300;
        final int BALL_COUNT = 1;
        final int MAX_MOVE_COUNT = 100;
        final int DELTA_TIME = 100;

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
            MovableBall ball = new MovableBall(x, y, radius);
            int dx = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);
            int dy = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);

            String sequence = "00" + (world.getCount() + 1);
            ball.setName("ball_" + sequence.substring(sequence.length() - 2));
            ball.setDX(dx);
            ball.setDY(dy);

            world.add(ball);
        }

        frame.setVisible(true);
        frame.setEnabled(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }
}

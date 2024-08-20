package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 400;
    static final int BALL_COUNT = 2;
    static final int MOVE_COUNT = 0;
    static final Color[] colors = new Color[] {
            Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN
    };

    public static void main(String[] args) {
        Random random = new Random();
        JFrame frame = new JFrame();

        BoundedWorld world = new BoundedWorld();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        world.add(new PaintableBall(FRAME_WIDTH / 2, FRAME_HEIGHT / 2, FRAME_HEIGHT / 4, Color.YELLOW));
        while (world.getCount() < BALL_COUNT) {
            try {
                MovableBall ball = new MovableBall(
                        random.nextInt(FRAME_WIDTH),
                        random.nextInt(FRAME_HEIGHT),
                        10 + random.nextInt(41),
                        colors[random.nextInt(colors.length)]);

                ball.setDX((random.nextInt() < 0) ? -(random.nextInt(5) + 1) : (random.nextInt(5) + 1));
                ball.setDY((random.nextInt() < 0) ? -(random.nextInt(5) + 1) : (random.nextInt(5) + 1));

                world.add(ball);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        frame.repaint();

        world.setMaxMoveVount(MOVE_COUNT);
        world.run();
    }
}
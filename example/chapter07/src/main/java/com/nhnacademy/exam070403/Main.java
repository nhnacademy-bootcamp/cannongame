package com.nhnacademy.exam070403;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        final int WORLD_WIDTH = 400;
        final int WORLD_HEIGHT = 300;
        final int MAX_MOVE_COUNT = 0;
        final int DELTA_TIME = 100;

        JFrame frame = new JFrame();
        frame.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BoundedWorld world = new BoundedWorld();
        world.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.add(world);

        MovableBall ball = new MovableBall(new Point(50, 50), 25, Color.RED);
        ball.setMotion(new Motion(15, 20));

        world.add(ball);
        world.addEffect(new Motion(0, -1));
        world.addEffect(new Motion(1, 0));

        frame.setVisible(true);
        frame.setEnabled(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }
}

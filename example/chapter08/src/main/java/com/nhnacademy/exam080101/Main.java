package com.nhnacademy.exam080101;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        final int WORLD_WIDTH = 400;
        final int WORLD_HEIGHT = 300;
        final int MAX_MOVE_COUNT = 0;
        final int DELTA_TIME = 10;

        JFrame frame = new JFrame();
        frame.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BoundedWorld world = new BoundedWorld();
        world.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.add(world);

        int x1 = 50;
        int y1 = 25;
        int width1 = 100;
        int height1 = 50;

        world.add(new PaintableBox(new Point(x1, y1), width1, height1, Color.RED));

        int x2 = 50;
        int y2 = 275;
        int width2 = 100;
        int height2 = 50;
        world.add(new PaintableBox(new Point(x2, y2), width2, height2, Color.BLUE));

        frame.setVisible(true);
        frame.setEnabled(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }
}

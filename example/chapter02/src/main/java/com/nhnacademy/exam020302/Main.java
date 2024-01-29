package com.nhnacademy.exam020302;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhnacademy.PaintableBall;

public class Main {
    public static void main(String[] args) {
        final int MAX_RADIUS = 50;
        final int MIN_RADIUS = 10;
        final Color[] colors = { Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN };
        Random random = new Random();

        JFrame frame = new JFrame();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        frame.add(world);

        while (world.getCount() < 10) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = radius + random.nextInt(frame.getWidth() - 2 * radius);
            int y = radius + random.nextInt(frame.getHeight() - 2 * radius);
            Color color = colors[random.nextInt(colors.length)];

            world.add(new PaintableBall(x, y, radius, color));
        }

        frame.setVisible(true);
        frame.setEnabled(true);
    }
}

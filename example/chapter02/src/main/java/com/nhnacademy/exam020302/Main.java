package com.nhnacademy.exam020302;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 볼을 출력해 보기 위한 테스트 프레임.
 */
public class Main {
    static final int MAX_RADIUS = 50;
    static final int MIN_RADIUS = 10;
    static final Color[] colors = { Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN };

    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        final int WORLD_WIDTH = 400;
        final int WORLD_HEIGHT = 300;
        Random random = new Random();

        World world = new World();
        world.setLocation(0, 0);
        world.setSize(WORLD_WIDTH, WORLD_HEIGHT);

        while (world.getCount() < 10) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = radius + random.nextInt(world.getWidth() - 2 * radius);
            int y = radius + random.nextInt(world.getHeight() - 2 * radius);
            Color color = colors[random.nextInt(colors.length)];

            world.add(new PaintableBall(x, y, radius, color));
        }

        JFrame frame = new JFrame();
        frame.add(world);

        int frameWidth = 0;
        int frameHeight = 0;
        Dimension dimension = getDimension(frame);
        System.out.println("W : " + dimension.getWidth()
                + ", H : " + dimension.getHeight());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        frame.setEnabled(true);
    }

    public static Dimension getDimension(Component component) {
        int width = 0;
        int height = 0;

        for (Component c : ((Container) component).getComponents()) {
            if (c instanceof Container) {
                Dimension sub = getDimension(c);

                width = Math.max(width, (int) sub.getWidth());
                height = Math.max(height, (int) sub.getHeight());
            } else {
                width = Math.max(width, component.getWidth());
                height = Math.max(height, component.getHeight());
            }
        }

        return new Dimension(width, height);
    }
}

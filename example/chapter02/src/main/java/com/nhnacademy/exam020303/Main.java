package com.nhnacademy.exam020303;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        Logger logger = LogManager.getLogger();

        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        world.setSize(400, 300);
        frame.add(world);

        while (world.getCount() < 10) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = random.nextInt(world.getWidth());
            int y = random.nextInt(world.getHeight());
            Color color = colors[random.nextInt(colors.length)];

            try {
                world.add(new PaintableBall(x, y, radius, color));
            } catch (IllegalArgumentException e) {
                logger.warn(e.getMessage());
            }
        }

        frame.setVisible(true);
        frame.setEnabled(true);
    }
}

package com.nhnacademy;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 600;
    static final int DT = 1000;
    static final int STATIC_BOX_COUNT = 5;
    static final int BOX_MIN_WIDTH = 10;
    static final int BOX_MAX_WIDTH = 100;
    static final int BOX_MIN_HEIGHT = 10;
    static final int BOX_MAX_HEIGHT = 100;
    static final int MOVABLE_BALL_COUNT = 1;
    static final int BALL_MIN_RADIUS = 5;
    static final int BALL_MAX_RADIUS = 30;
    static final int BALL_MIN_SPEED = 1;
    static final int BALL_MAX_SPEED = 5;

    public static void main(String[] args) {
        Logger log = LogManager.getLogger("main");

        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        MovableWorld world = new MovableWorld();
        frame.add(world);
        frame.setVisible(true);

        world.setDT(DT);
        world.setMaxMoveCount(0);

        while (world.getCount() < STATIC_BOX_COUNT) {
            int width = BOX_MIN_WIDTH + random.nextInt(BOX_MAX_WIDTH - BOX_MIN_WIDTH);
            int height = BOX_MIN_HEIGHT + random.nextInt(BOX_MAX_HEIGHT - BOX_MIN_HEIGHT);
            int x = width / 2 + random.nextInt(world.getWidth() - width);
            int y = height / 2 + random.nextInt(world.getHeight() - height);

            world.add(new PaintableBox(x, y, width, height, Color.RED));
        }

        while (world.getCount() < STATIC_BOX_COUNT + MOVABLE_BALL_COUNT) {
            int radius = BALL_MIN_RADIUS + random.nextInt(BALL_MAX_RADIUS - BALL_MIN_RADIUS);
            int x = radius + random.nextInt(world.getWidth() - 2 * radius);
            int y = radius + random.nextInt(world.getHeight() - 2 * radius);

            MovableBall ball = new BoundedBall(x, y, radius, Color.GREEN);

            boolean collision = false;
            for (int i = 0; !collision && i < world.getCount(); i++) {
                Regionable regionable = world.get(i);
                collision = ball.intersects(regionable);
            }

            if (!collision) {
                int dx = (random.nextInt() % 2 == 0 ? -1 : 1)
                        * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));
                int dy = (random.nextInt() % 2 == 0 ? -1 : 1)
                        * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));
                ball.setMotion(new PositionalVector(dx, dy));
                world.add(ball);
            }
        }

        world.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();

                log.debug("Clicked : {}", point);

                int radius = BALL_MIN_RADIUS + random.nextInt(BALL_MAX_RADIUS - BALL_MIN_RADIUS);

                Region region = new Region((int) point.getX(), (int) point.getY(), 2 * radius, 2 * radius);

                boolean collision = false;
                for (int i = 0; !collision && i < world.getCount(); i++) {
                    collision = world.get(i).getRegion().intersects(region);
                    if (collision) {
                        log.debug("Clicked : {} ", world.get(i));
                        world.remove(i);
                    }
                }

                if (!collision) {
                    BoundedBall ball = new BoundedBall((int) point.getX(), (int) point.getY(), radius, Color.GREEN);
                    int dx = (random.nextInt() % 2 == 0 ? 1 : -1)
                            * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));
                    int dy = (random.nextInt() % 2 == 0 ? 1 : -1)
                            * (BALL_MIN_SPEED + random.nextInt(BALL_MAX_SPEED - BALL_MIN_SPEED));

                    ball.setMotion(new PositionalVector(dx, dy));
                    ball.setBounds(world.getBounds());

                    world.add(ball);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // unused
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // not used
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // unused
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // unused
            }

        });
        world.run();
    }
}
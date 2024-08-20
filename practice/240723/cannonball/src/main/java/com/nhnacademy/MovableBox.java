package com.nhnacademy;

import java.awt.Color;

public class MovableBox extends PaintableBox implements Movable {
    public static final int DEFAULT_DT = 200;

    Vector motion = new PositionalVector(0, 0);
    int dt = DEFAULT_DT;
    boolean running = false;

    public MovableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public MovableBox(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public int getDX() {
        return motion.getDX();
    }

    public int getDY() {
        return motion.getDY();
    }

    public void setDX(int dx) {
        motion = new PositionalVector(dx, motion.getDY());
    }

    public void setDY(int dy) {
        motion = new PositionalVector(motion.getDX(), dy);
    }

    public Vector getMotion() {
        return motion;
    }

    public void setMotion(Vector motion) {
        this.motion = motion;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public int getDT() {
        return dt;
    }

    public void move() {
        region.translate(motion.getDX(), motion.getDY());
    }

    public void moveTo(int x, int y) {
        region.setLocation(x, y);
        log.debug("Move to {}, {}", x, y);
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            move();
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }
    }
}

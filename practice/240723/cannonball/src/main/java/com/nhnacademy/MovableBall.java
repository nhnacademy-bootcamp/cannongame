package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends PaintableBall implements Movable {
    public static final int DEFAULT_DT = 100;

    Vector motion = new PositionalVector(0, 0);
    int dt = DEFAULT_DT;
    boolean running = false;

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
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
        log.debug("Move to {}, {}", getRegion().getCenterX(), getRegion().getCenterY());
        region.translate(motion.getDX(), motion.getDY());
    }

    public void moveTo(int x, int y) {
        region.setLocation(x, y);
        log.debug("Move to {}, {}", x, y);
    }

    @Override
    public void run() {
        log.debug("Run : {}", Thread.currentThread());
        running = true;

        while (running) {
            try {
                move();
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }
    }
}

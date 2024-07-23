package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends PaintableBall {
    int dx;
    int dy;

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move() {
        moveTo(getX() + getDX(), getY() + getDY());
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        log.debug("Move to {}, {}", x, y);
    }
}

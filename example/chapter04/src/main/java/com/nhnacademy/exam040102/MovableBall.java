package com.nhnacademy.exam040102;

import java.awt.Color;

public class MovableBall extends PaintableBall {
    int dx = 0;
    int dy = 0;

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public int getDX() {
        return dx;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move() {
        moveTo(getX() + getDX(), getY() + getDY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
        getLogger().trace(getName() + " move to : x = " + getX() + ", y = " + getY());
    }
}

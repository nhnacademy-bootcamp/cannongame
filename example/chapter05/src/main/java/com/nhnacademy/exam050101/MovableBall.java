package com.nhnacademy.exam050101;

import java.awt.Color;

public class MovableBall extends PaintableBall {
    int dx = 0;
    int dy = 0;

    public MovableBall(Point location, int radius) {
        super(location, radius);
    }

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);
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
        Point newLocation = new Point(getLocation());
        newLocation.translate(getDX(), getDY());

        setLocation(newLocation);
    }

    public void moveTo(Point location) {
        setLocation(location);
    }
}

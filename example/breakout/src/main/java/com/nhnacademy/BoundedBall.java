package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {

    Rectangle bounds;

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);

        bounds = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        bounds = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds);
    }

    public boolean isOutOfBounds() {
        return (getMinX() < bounds.getMinX())
                || (bounds.getMaxX() < getMaxX())
                || (getMinY() < bounds.getMinY())
                || (bounds.getMaxY() < getMaxY());
    }

    @Override
    public void move() {
        super.move();
        if (isOutOfBounds()) {
            bounce();
        }
    }

    public void bounce() {
        if ((getMinX() < bounds.getMinX()) || (bounds.getMaxX() < getMaxX())) {
            setDX(-getDX());
        }

        if ((getMinY() < bounds.getMinY()) || (bounds.getMaxY() < getMaxY())) {
            setDY(-getDY());
        }
    }
}

package com.nhnacademy.exam040301;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);

        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        return (getX() - getRadius() < bounds.getMinX())
                || (getX() + getRadius() > bounds.getMaxX())
                || (getY() - getRadius() < bounds.getMinY())
                || (getY() + getRadius() > bounds.getMaxY());
    }

    public void bounce() {
        if (getX() - getRadius() < bounds.getMinX()) {
            moveTo((int) bounds.getMinX() + getRadius(), getY());
            setDX(-getDX());

        } else if (getX() + getRadius() > bounds.getMaxX()) {
            moveTo((int) bounds.getMaxX() - getRadius(), getY());
            setDX(-getDX());
        }

        if (getY() - getRadius() < bounds.getMinY()) {
            moveTo(getX(), (int) bounds.getMinY() + getRadius());
            setDY(-getDY());
        } else if (getY() + getRadius() > bounds.getMaxY()) {
            moveTo(getX(), (int) bounds.getMaxY() - getRadius());
            setDY(-getDY());
        }
    }

    @Override
    public void move() {
        super.move();
        if (isOutOfBounds()) {
            bounce();
        }
    }
}

package com.nhnacademy.exam040304;

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
            int newX = 2 * ((int) bounds.getMinX() + getRadius()) - getX();
            moveTo(newX, getY());
            setDX(-getDX());
        } else if (getX() + getRadius() > bounds.getMaxX()) {
            int newX = 2 * ((int) bounds.getMaxX() - getRadius()) - getX();
            moveTo(newX, getY());
            setDX(-getDX());
        }

        if (getY() - getRadius() < bounds.getMinY()) {
            int newY = 2 * ((int) bounds.getMinY() + getRadius()) - getY();
            moveTo(getX(), newY);
            setDY(-getDY());
        } else if (getY() + getRadius() > bounds.getMaxY()) {
            int newY = 2 * ((int) bounds.getMaxY() - getRadius()) - getY();
            moveTo(getX(), newY);
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

package com.nhnacademy.exam050100;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);

        bounds = getRegion();
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        bounds = getRegion();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        return !getRegion().equals(bounds.intersection(getRegion()));
    }

    public void bounce() {
        if (getRegion().getMinX() < bounds.getMinX()) {
            moveTo((int) (2 * bounds.getMinX() + getRadius() - getMinX()), getY());
            setDX(-getDX());
        } else if (getRegion().getX() + getRadius() > bounds.getMaxX()) {
            moveTo((int) (2 * bounds.getMaxX() - getRadius() - getMaxX()), getY());
            setDX(-getDX());
        }

        if (getRegion().getY() - getRadius() < bounds.getMinY()) {
            moveTo(getX(), (int) (2 * bounds.getMinY() + getRadius() - getMinY()));
            setDY(-getDY());
        } else if (getRegion().getY() + getRadius() > bounds.getMaxY()) {
            moveTo(getX(), (int) (2 * bounds.getMaxY() - getRadius() - getMaxY()));
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

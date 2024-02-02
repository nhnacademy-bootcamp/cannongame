package com.nhnacademy.exam050101;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    Rectangle bounds;

    public BoundedBall(Point location, int radius) {
        super(location, radius);

        bounds = getRegion();
    }

    public BoundedBall(Point location, int radius, Color color) {
        super(location, radius, color);

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
            moveTo(new Point((int) (2 * bounds.getMinX() + getRadius() - getRegion().getMinX()), getLocation().getY()));
            setDX(-getDX());
        } else if (getRegion().getMaxX() > bounds.getMaxX()) {
            moveTo(new Point((int) (2 * bounds.getMaxX() - getRadius() - getRegion().getMaxX()), getLocation().getY()));
            setDX(-getDX());
        }

        if (getRegion().getMinY() - getRadius() < bounds.getMinY()) {
            moveTo(new Point(getLocation().getX(), (int) (2 * bounds.getMinY() + getRadius() - getRegion().getMinY())));
            setDY(-getDY());
        } else if (getRegion().getMaxY() + getRadius() > bounds.getMaxY()) {
            moveTo(new Point(getLocation().getX(), (int) (2 * bounds.getMaxY() - getRadius() - getRegion().getMaxY())));
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

package com.nhnacademy.exam060201;

import java.awt.Color;

public class BoundedBall extends MovableBall {
    Region bounds;

    public BoundedBall(Point location, int radius) {
        super(location, radius);

        bounds = getRegion();
    }

    public BoundedBall(Point location, int radius, Color color) {
        super(location, radius, color);

        bounds = getRegion();
    }

    public Region getBounds() {
        return bounds;
    }

    public void setBounds(Region bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        return !getRegion().equals(bounds.intersection(getRegion()));
    }

    public void bounce() {
        if ((getRegion().getMinX() < bounds.getMinX()) || (getRegion().getMaxX() > bounds.getMaxX())) {
            getMotion().turnDX();
        }

        if ((getRegion().getMinY() < bounds.getMinY()) || (getRegion().getMaxY() > bounds.getMaxY())) {
            getMotion().turnDY();
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

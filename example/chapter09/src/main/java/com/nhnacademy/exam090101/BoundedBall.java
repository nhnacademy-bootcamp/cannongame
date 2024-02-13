package com.nhnacademy.exam090101;

import java.awt.Color;

public class BoundedBall extends MovableBall {
    Region bounds;

    public BoundedBall(Point location, int radius) {
        super(location, radius);

        bounds = new Region(this);
    }

    public BoundedBall(Point location, int radius, Color color) {
        super(location, radius, color);

        bounds = new Region(this);
    }

    public Region getBounds() {
        return bounds;
    }

    public void setBounds(Region bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        return equals(bounds.intersection(this));
    }

    public void bounce() {
        if ((getMinX() < bounds.getMinX()) || (getMaxX() > bounds.getMaxX())) {
            getMotion().turnDX();
        }

        if ((getMinY() < bounds.getMinY()) || (getMaxY() > bounds.getMaxY())) {
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

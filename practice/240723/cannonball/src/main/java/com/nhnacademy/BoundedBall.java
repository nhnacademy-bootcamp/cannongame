package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall implements Bounded {

    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds);
    }

    public boolean isOutOfBounds() {
        return (getMinX() < bounds.getMinX())
                || getMaxX() > bounds.getMaxX()
                || getMinY() < bounds.getMinY()
                || getMaxY() > bounds.getMaxY();
    }

    @Override
    public void move() {
        super.move();

        if (isOutOfBounds()) {
            if ((getMinX() < bounds.getMinX()) || (getMaxX() > bounds.getMaxX())) {
                setDX(-getDX());
            }

            if ((getMinY() < bounds.getMinY()) || (getMaxY() > bounds.getMaxY())) {
                setDY(-getDY());
            }
        }
    }

    @Override
    public boolean isOutOfBounds(Rectangle bounds) {
        return getRegion().intersects(new Region(bounds));
    }
}

package com.nhnacademy;

public class Ball extends Region {
    public Ball(Point loaction, int radius) {
        super(loaction, 2 * radius, 2 * radius);
    }

    public Ball(Ball other) {
        super(other.getLocation(), other.getWidth(), other.getHeight());
    }

    public int getRadius() {
        return getWidth() / 2;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Ball)
                && super.equals(other);
    }
}

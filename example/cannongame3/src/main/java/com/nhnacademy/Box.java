package com.nhnacademy;

public class Box extends Region {
    public Box(Point location, int width, int height) {
        super(location, width, height);
    }

    public Box(Box other) {
        super(other.getLocation(), other.getWidth(), other.getHeight());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Box)
                && super.equals(other);
    }
}

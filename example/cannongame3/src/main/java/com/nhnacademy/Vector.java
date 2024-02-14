package com.nhnacademy;

public class Vector {
    int dx = 0;
    int dy = 0;

    Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public int getMagnitude() {
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public int getAngle() {
        if (dx == 0) {
            if (dy > 0) {
                return 90;
            } else if (dy < 0) {
                return -90;
            } else {
                return 0;
            }
        } else if (dy == 0) {
            if (dx < 0) {
                return 180;
            } else {
                return 0;
            }
        }

        return (int) Math.atan((double) dy / dx);
    }

    public void set(Vector other) {
        dx = other.getDX();
        dy = other.getDY();
    }

    public void add(Vector other) {
        dx += other.getDX();
        dy += other.getDY();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Vector)
                && (getDX() == ((Vector) other).getDX())
                && (getDY() == ((Vector) other).getDY());
    }
}

package com.nhnacademy;

public class Vector {
    int dx;
    int dy;

    protected Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Vector(Vector other) {
        dx = other.getDX();
        dy = other.getDY();
    }

    public void add(Vector other) {
        dx += other.getDX();
        dy += other.getDY();
    }

    public void sub(Vector other) {
        dx -= other.getDX();
        dy -= other.getDY();
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public int getAngle() {
        if (dx == 0) {
            if (dy >= 0) {
                return 90;
            } else {
                return -90;
            }
        }
        return (int) Math.toDegrees(Math.atan(dy / (double) dx));
    }

    public int getMagnitude() {
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public void turnDX() {
        dx = -dx;
    }

    public void turnDY() {
        dy = -dy;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vector)
                && (getDX() == ((Vector) o).getDX())
                && (getDY() == ((Vector) o).getDY());
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", getDX(), getDY());
    }

    static Vector add(Vector op1, Vector op2) {
        return new PositionalVector(op1.getDX() + op2.getDX(), op1.getDY() + op2.getDY());
    }

    static Vector sub(Vector op1, Vector op2) {
        return new PositionalVector(op1.getDX() - op2.getDX(), op1.getDY() - op2.getDY());
    }
}

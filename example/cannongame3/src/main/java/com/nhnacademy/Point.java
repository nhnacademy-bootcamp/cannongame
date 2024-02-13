package com.nhnacademy;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        long longX = x;
        long longY = y;
        if (((longX + dx) != (x + dx))
                || ((longY + dy) != (y + dy))) {
            throw new OutOfBoundsException();
        }
        x += dx;
        y += dy;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Point)
                && (hashCode() == other.hashCode())
                && (getX() == ((Point) other).getX())
                && (getY() == ((Point) other).getY());
    }

    @Override
    public int hashCode() {
        return getX() + getY();
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}

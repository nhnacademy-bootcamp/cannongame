package com.nhnacademy;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        x = other.getX();
        y = other.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void translate(Vector displacement) {
        x += displacement.getDX();
        y += displacement.getDY();
    }

    void moveTo(Point other) {
        x = other.getX();
        y = other.getY();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Point) && (x == ((Point) other).getX()) && (y == ((Point) other).getY());
    }

    @Override
    public int hashCode() {
        return x + y;
    }
}

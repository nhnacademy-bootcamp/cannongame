package com.nhnacademy.exam060301;

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

    void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    public void move(Motion motion) {
        moveTo(getX() + motion.getDX(), getY() + motion.getDY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    public void moveTo(Point other) {
        setX(other.getX());
        setY(other.getY());
    }

    public static int distance(Point point1, Point point2) {
        return (int) Math.sqrt(Math.pow((double) point1.getX() - point2.getX(), 2)
                + Math.pow((double) point1.getY() - point2.getY(), 2));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

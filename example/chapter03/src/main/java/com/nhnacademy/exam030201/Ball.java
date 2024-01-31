package com.nhnacademy.exam030201;

public class Ball {
    int x;
    int y;
    int radius;

    public Ball(int x, int y, int radius) {
        if ((radius <= 0)
                || ((x >= 0) && ((Integer.MAX_VALUE - x) < radius))
                || ((x < 0) && ((x - Integer.MIN_VALUE) < radius))
                || ((y >= 0) && ((Integer.MAX_VALUE - y) < radius))
                || ((y < 0) && ((y - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
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

    public int getRadius() {
        return radius;
    }
}
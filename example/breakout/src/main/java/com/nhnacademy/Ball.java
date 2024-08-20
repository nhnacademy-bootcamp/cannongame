package com.nhnacademy;

import java.awt.Rectangle;

public class Ball implements Bounded {
    int x;
    int y;
    int radius;

    public Ball(int x, int y, int radius) {
        if (((long) x + radius > Integer.MAX_VALUE)
                || ((long) x - radius < Integer.MIN_VALUE)
                || ((long) y + radius > Integer.MAX_VALUE)
                || ((long) y - radius < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("볼이 공간을 벗어 납니다.");
        }

        if (radius < 0) {
            throw new IllegalArgumentException("반지름은 음수가 될 수 없습니다.");
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getMinX() {
        return x - radius;
    }

    public int getMaxX() {
        return x + radius;
    }

    public int getMinY() {
        return y - radius;
    }

    public int getMaxY() {
        return y + radius;
    }

    public int getWidth() {
        return 2 * radius;
    }

    public int getHeight() {
        return 2 * radius;
    }

    public Rectangle getBounds() {
        return new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[")
                .append(x).append(",")
                .append(y).append(",")
                .append(radius)
                .append("]");

        return sb.toString();
    }

}

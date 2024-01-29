package com.nhnacademy.exam020203;

/**
 * 2차원 공간에서의 볼을 표현하기 위한 최소한의 정보만 가짐.
 */
public class Ball {
    int x;
    int y;
    int radius;

    /**
     * Constructor.
     *
     * @param x      X축 좌표
     * @param y      Y축 좌표
     * @param radius 반지름
     */
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

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class MovableBall extends PaintableBall implements Movable {
    int dx;
    int dy;

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move() {
        // System.out.printf("(%d, %d) -> ", getX(), getY());
        moveTo(getX() + dx, getY() + dy);
        // System.out.printf("(%d, %d)%n", getX(), getY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    public void bounce(Bounded bounded) {
        if (getBounds().intersects(bounded.getBounds())) {
            Rectangle intersection = getBounds().intersection(bounded.getBounds());

            if (intersection.getWidth() != getBounds().getWidth() && intersection.getWidth() != bounded.getWidth()) {
                setDX(-getDX());
            }

            if (intersection.getHeight() != getBounds().getHeight()
                    && intersection.getHeight() != bounded.getHeight()) {
                setDY(-getDY());
            }

        }
    }
}

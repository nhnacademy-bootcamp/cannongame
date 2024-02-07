package com.nhnacademy.exam080201;

import java.awt.Color;

public class MovableBall extends PaintableBall implements Movable {
    Motion motion = Motion.createPosition(0, 0);

    public MovableBall(Point location, int radius) {
        super(location, radius);
    }

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public Motion getMotion() {
        return motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public void move() {
        move(getMotion());
        System.out.println("X : " + getLocation().getX() + ", Y : " + getLocation().getY());
    }
}

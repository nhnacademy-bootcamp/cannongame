package com.nhnacademy.exam060401;

import java.awt.Color;

public class MovableBox extends PaintableBox {
    Motion motion = Motion.createPosition(0, 0);

    public MovableBox(Point location, int width, int height) {
        super(location, width, height);
    }

    public MovableBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);
    }

    public Motion getMotion() {
        return motion;
    }

    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public void move() {
        move(getMotion());
    }
}

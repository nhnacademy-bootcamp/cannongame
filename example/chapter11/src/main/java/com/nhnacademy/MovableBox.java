package com.nhnacademy;

import java.awt.Color;

public class MovableBox extends PaintableBox implements Movable {
    Vector displacement = new DisplacementVector(0, 0);
    boolean stopped = false;

    public MovableBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);
    }

    public MovableBox(Point location, int width, int height) {
        super(location, width, height);
    }

    public void setDisplacement(Vector displacement) {
        this.displacement = new Vector(displacement);
    }

    public Vector getDisplacement() {
        return displacement;
    }

    public void addEffect(Vector effect) {
        displacement.add(effect);
    }

    public void move() {
        tranlate(displacement);
    }

    public void turnX() {
        getDisplacement().turnX();
    }

    public void turnY() {
        getDisplacement().turnY();
    }

    public void stop() {
        stopped = true;
    }

    public boolean isStopped() {
        return stopped;
    }
}

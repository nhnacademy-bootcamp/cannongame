package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends PaintableBall implements Movable {
    Vector displacement = new DisplacementVector(0, 0);
    boolean stopped = false;

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public MovableBall(Point location, int radius) {
        super(location, radius);
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
        if (!stopped) {
            tranlate(displacement);
        }
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

package com.nhnacademy.exam090201;

import java.awt.Color;

public class BoundedBall extends MovableBall implements Bounded {
    double cor = 1.0;

    public BoundedBall(Point location, int radius) {
        super(location, radius);
    }

    public BoundedBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    @Override
    public double getCOR() {
        return cor;
    }

    public void setCOR(double cor) {
        this.cor = cor;
    }

    public void applyCOR() {
        getMotion().setDX((int) (getMotion().getDX() * cor));
        getMotion().setDY((int) (getMotion().getDY() * cor));
    }

    public void applyCOR(double externalCOR) {
        getMotion().setDX((int) (getMotion().getDX() * cor * externalCOR));
        getMotion().setDY((int) (getMotion().getDY() * cor * externalCOR));
    }
}

package com.nhnacademy.exam090201;

import java.awt.Color;

public class BoundedBox extends MovableBox implements Bounded {
    double cor = 1.0;

    public BoundedBox(Point location, int width, int height) {
        super(location, width, height);
    }

    public BoundedBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);
    }

    @Override
    public double getCOR() {
        return cor;
    }

    @Override
    public void setCOR(double cor) {
        this.cor = cor;
    }

    @Override
    public void applyCOR() {
        getMotion().setDX((int) (getMotion().getDX() * cor));
        getMotion().setDY((int) (getMotion().getDY() * cor));
    }

    @Override
    public void applyCOR(double externalCOR) {
        getMotion().setDX((int) (getMotion().getDX() * cor * externalCOR));
        getMotion().setDY((int) (getMotion().getDY() * cor * externalCOR));
    }
}

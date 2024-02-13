package com.nhnacademy;

public interface Movable {
    public void setDisplacement(Vector displacement);

    public Vector getDisplacement();

    public void addEffect(Vector effect);

    public void move();

    public void turnX();

    public void turnY();

    public void stop();

    public boolean isStopped();
}

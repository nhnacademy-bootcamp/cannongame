package com.nhnacademy.exam070403;

public interface Movable extends Regionable {
    public Motion getMotion();

    public void setMotion(Motion motion);

    public void move();

    public void addEffect(Motion effect);
}
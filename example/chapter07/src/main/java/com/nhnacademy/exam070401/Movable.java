package com.nhnacademy.exam070401;

public interface Movable extends Regionable {
    public Motion getMotion();

    public void setMotion(Motion motion);

    public void move();
}
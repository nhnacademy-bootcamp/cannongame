package com.nhnacademy.exam070301;

public interface Movable extends Regionable {
    public Motion getMotion();

    public void setMotion(Motion motion);

    public void move();
}
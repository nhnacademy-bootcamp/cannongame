package com.nhnacademy;

public interface Movable {

    public int getDX();

    public int getDY();

    public void setDX(int dx);

    public void setDY(int dy);

    public void move();

    public void moveTo(int x, int y);

    public void bounce(Bounded bounded);
}

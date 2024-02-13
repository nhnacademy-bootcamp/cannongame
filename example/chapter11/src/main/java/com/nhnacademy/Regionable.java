package com.nhnacademy;

public interface Regionable {

    public Point getLocation();

    public int getWidth();

    public int getHeight();

    public int getCenterX();

    public int getMinX();

    public int getMaxX();

    public int getMinY();

    public int getMaxY();

    public int getCenterY();

    public void tranlate(Vector displacement);

    public boolean isCollision(Regionable other);

    public Region getIntersection(Regionable other);

    public double getCOR();

    public void setCOR(double cor);
}

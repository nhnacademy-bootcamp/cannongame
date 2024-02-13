package com.nhnacademy.exam090201;

public interface Regionable {
    public Point getLocation();

    public int getWidth();

    public int getHeight();

    public int getMinX();

    public int getMaxX();

    public int getMinY();

    public int getMaxY();

    void moveTo(Point location);

    public boolean intersects(Regionable other);

    public Regionable intersection(Regionable other);

    public default double getCOR() {
        return 1.0;
    }

    public default void setCOR(double cor) {
    }

}
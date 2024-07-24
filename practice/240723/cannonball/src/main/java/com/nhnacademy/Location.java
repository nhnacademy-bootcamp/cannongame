package com.nhnacademy;

public class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location location) {
        x = location.getX();
        y = location.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Location)
                && (getX() == ((Location) o).getX())
                && (getY() == ((Location) o).getY());
    }
}

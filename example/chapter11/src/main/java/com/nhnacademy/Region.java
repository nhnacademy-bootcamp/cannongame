package com.nhnacademy;

public class Region implements Regionable {
    Point location;
    int width = 0;
    int height = 0;
    double cor = 1;

    public Region() {
        location = new Point(0, 0);
    }

    public Region(Region other) {
        location = new Point(other.getLocation());
        width = other.getWidth();
        height = other.getHeight();
    }

    public Region(Point location, int width, int height) {
        this.location = new Point(location);
        this.width = width;
        this.height = height;
    }

    public Point getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMinX() {
        return location.getX() - getWidth() / 2;
    }

    public int getMaxX() {
        return location.getX() + getWidth() / 2;
    }

    public int getCenterX() {
        return location.getX();
    }

    public int getMinY() {
        return location.getY() - getHeight() / 2;
    }

    public int getMaxY() {
        return location.getY() + getHeight() / 2;
    }

    public int getCenterY() {
        return location.getY();
    }

    public void tranlate(Vector displacement) {
        location.translate(displacement);
    }

    void moveTo(Point location) {
        this.location.moveTo(location);
    }

    public boolean isCollision(Regionable other) {
        return !(getMaxX() < other.getMinX()
                || getMinX() > other.getMaxX()
                || getMaxY() < other.getMinY()
                || getMinY() > other.getMaxY());
    }

    public Region getIntersection(Regionable other) {
        int minX = Math.max(getMinX(), other.getMinX());
        int maxX = Math.min(getMaxX(), other.getMaxX());
        int minY = Math.max(getMinY(), other.getMinY());
        int maxY = Math.min(getMaxY(), other.getMaxY());

        return new Region(new Point((minX + maxX) / 2, (minY + maxY) / 2),
                Math.max(0, maxX - minX), Math.max(0, maxY - minY));
    }

    @Override
    public double getCOR() {
        return cor;
    }

    @Override
    public void setCOR(double cor) {
        this.cor = cor;
    }
}

package com.nhnacademy;

import java.awt.Rectangle;

public class Region {
    Location location;
    Dimension dimension;

    public Region(int x, int y, int width, int height) {
        this.location = new Location(x, y);
        this.dimension = new Dimension(width, height);
    }

    public Region(Location location, int width, int height) {
        this(location.getX(), location.getY(), width, height);
    }

    public Region(Location location, Dimension dimension) {
        this(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight());
    }

    private Region(Rectangle rectangle) {
        this.location = new Location((int) rectangle.getCenterX(), (int) rectangle.getCenterY());
        this.dimension = new Dimension((int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = new Location(location);
    }

    public void setLocation(int x, int y) {
        this.location = new Location(x, y);
    }

    public int getCenterX() {
        return location.getX();
    }

    public int getMinX() {
        return location.getX() - dimension.getWidth() / 2;
    }

    public int getMaxX() {
        return location.getX() + dimension.getWidth() / 2;
    }

    public int getCenterY() {
        return location.getY();
    }

    public int getMinY() {
        return location.getY() - dimension.getHeight() / 2;
    }

    public int getMaxY() {
        return location.getY() + dimension.getHeight() / 2;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public int getWidth() {
        return dimension.getWidth();
    }

    public int getHeight() {
        return dimension.getHeight();
    }

    public void translate(int dx, int dy) {
        location.translate(dx, dy);
    }

    public boolean intersects(Region other) {
        return getRectangle().intersects(other.getRectangle());
    }

    public Region intersection(Region other) {
        return new Region(getRectangle().intersection(other.getRectangle()));
    }

    private Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(getMinX(), getMinY(), dimension.getWidth(), dimension.getHeight());

        return rectangle;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Region)
                && location.equals(((Region) o).getLocation())
                && dimension.equals(((Region) o).getDimension());
    }
}

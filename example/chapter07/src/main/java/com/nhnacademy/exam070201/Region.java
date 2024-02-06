package com.nhnacademy.exam070201;

import java.awt.Rectangle;

public class Region implements Regionable {
    Point location;
    int width;
    int height;

    public Region(Point location, int width, int height) {
        this.location = new Point(location);
        this.width = width;
        this.height = height;
    }

    public Region(Region other) {
        this.location = new Point(other.getLocation());
        this.width = other.getWidth();
        this.height = other.getHeight();
    }

    public Point getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMinX() {
        return location.getX() - width / 2;
    }

    public int getMaxX() {
        return location.getX() + width / 2;
    }

    public int getMinY() {
        return location.getY() - height / 2;
    }

    public int getMaxY() {
        return location.getY() + height / 2;
    }

    void move(Motion motion) {
        location.move(motion);
    }

    void moveTo(Point location) {
        this.location.moveTo(location);
    }

    public boolean intersects(Regionable other) {
        Rectangle rect1 = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
        Rectangle rect2 = new Rectangle(other.getMinX(), other.getMinY(), other.getWidth(), other.getHeight());

        return rect1.intersects(rect2);
    }

    public Regionable intersection(Regionable other) {
        Rectangle rect1 = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
        Rectangle rect2 = new Rectangle(other.getMinX(), other.getMinY(), other.getWidth(), other.getHeight());

        Rectangle commonArea = rect1.intersection(rect2);

        return new Region(new Point((int) (commonArea.getX() + commonArea.getWidth() / 2),
                (int) (commonArea.getY() + commonArea.getHeight() / 2)),
                (int) commonArea.getWidth(), (int) commonArea.getHeight());
    }
}

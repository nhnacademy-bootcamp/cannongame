package com.nhnacademy.exam050101;

import java.awt.Rectangle;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    String id = UUID.randomUUID().toString();
    String name = id;
    Point location;
    int radius;
    Logger logger;

    public Ball(Point location, int radius) {
        if ((radius <= 0)
                || ((location.getX() >= 0) && ((Integer.MAX_VALUE - location.getX()) < radius))
                || ((location.getX() < 0) && ((location.getX() - Integer.MIN_VALUE) < radius))
                || ((location.getY() >= 0) && ((Integer.MAX_VALUE - location.getY()) < radius))
                || ((location.getY() < 0) && ((location.getY() - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }

        this.location = new Point(location);
        this.radius = radius;
        this.logger = LogManager.getLogger(this.getClass());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    void setLocation(Point location) {
        this.location.moveTo(location);
    }

    public int getRadius() {
        return radius;
    }

    public Rectangle getRegion() {
        return new Rectangle(getLocation().getX() - getRadius(), getLocation().getY() - getRadius(),
                2 * getRadius(), 2 * getRadius());
    }

    public boolean isCollision(Ball other) {
        return Point.distance(getLocation(), other.getLocation()) - (getRadius() + other.getRadius()) < 0;
    }

    public Logger getLogger() {
        return logger;
    }
}
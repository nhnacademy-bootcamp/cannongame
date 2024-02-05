package com.nhnacademy.exam060301;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public Ball(Point location, int radius) {
        if ((radius <= 0)
                || ((location.getX() - radius) > location.getX())
                || ((location.getX() + radius) < location.getX())
                || ((location.getY() - radius) > location.getY())
                || ((location.getY() + radius) < location.getY())) {
            throw new IllegalArgumentException();
        }

        region = new Region(location, 2 * radius, 2 * radius);
        logger = LogManager.getLogger(this.getClass());
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
        return getRegion().getLocation();
    }

    void setLocation(Point location) {
        region.moveTo(location);
    }

    public int getRadius() {
        return (getRegion().getWidth() / 2);
    }

    public Region getRegion() {
        return region;
    }

    public boolean isCollision(Ball other) {
        return getRegion().intersects(other.getRegion());
    }

    public boolean isCollision(Box other) {
        return getRegion().intersects(other.getRegion());
    }

    public Logger getLogger() {
        return logger;
    }
}
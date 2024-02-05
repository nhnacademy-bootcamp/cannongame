package com.nhnacademy.exam060201;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public Box(Point location, int width, int height) {
        if ((width <= 0) || (height <= 0)
                || ((location.getX() - width / 2.0) > location.getX())
                || ((location.getX() + width / 2.0) < location.getX())
                || ((location.getY() - height / 2.0) > location.getY())
                || ((location.getY() + height / 2.0) < location.getY())) {
            throw new IllegalArgumentException();
        }

        region = new Region(location, width, height);
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

    public int getWidth() {
        return getRegion().getWidth();
    }

    public int getHeight() {
        return getRegion().getHeight();
    }

    public Region getRegion() {
        return region;
    }

    public boolean isCollision(Box other) {
        return getRegion().intersects(other.getRegion());
    }

    public Logger getLogger() {
        return logger;
    }
}
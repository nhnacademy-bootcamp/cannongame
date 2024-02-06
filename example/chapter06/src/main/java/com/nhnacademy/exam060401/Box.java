package com.nhnacademy.exam060401;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box extends Region {
    String id = UUID.randomUUID().toString();
    String name = id;
    Logger logger;

    public Box(Point location, int width, int height) {
        super(location, width, height);

        if ((width <= 0) || (height <= 0)
                || ((location.getX() - width / 2.0) > location.getX())
                || ((location.getX() + width / 2.0) < location.getX())
                || ((location.getY() - height / 2.0) > location.getY())
                || ((location.getY() + height / 2.0) < location.getY())) {
            throw new IllegalArgumentException();
        }

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

    public boolean isCollision(Region other) {
        return intersects(other);
    }

    public Logger getLogger() {
        return logger;
    }
}
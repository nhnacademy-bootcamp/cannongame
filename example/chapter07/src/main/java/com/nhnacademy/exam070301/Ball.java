package com.nhnacademy.exam070301;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball extends Region {
    String id = UUID.randomUUID().toString();
    String name = id;
    Logger logger;

    public Ball(Point location, int radius) {
        super(location, 2 * radius, 2 * radius);

        if ((radius <= 0)
                || ((location.getX() - radius) > location.getX())
                || ((location.getX() + radius) < location.getX())
                || ((location.getY() - radius) > location.getY())
                || ((location.getY() + radius) < location.getY())) {
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

    public int getRadius() {
        return (getWidth() / 2);
    }

    public Logger getLogger() {
        return logger;
    }
}
package com.nhnacademy.exam080201;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle extends Region {
    String id = UUID.randomUUID().toString();
    String name = id;
    Logger logger;

    public Triangle(Point location, int width, int height) {
        super(location, width, height);

        if (((location.getX() - width / 2) > location.getX())
                || ((location.getX() + width / 2) < location.getX())
                || ((location.getY() - height / 2) > location.getY())
                || ((location.getY() + height / 2) < location.getY())) {
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

    public Logger getLogger() {
        return logger;
    }
}
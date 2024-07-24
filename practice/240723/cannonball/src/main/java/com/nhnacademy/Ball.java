package com.nhnacademy;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball implements Regionable {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    static Logger log = LogManager.getLogger(Ball.class);

    Region region;
    Color color;

    public Ball(int x, int y, int radius, Color color) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }

        this.region = new Region(x, y, 2 * radius, 2 * radius);
        this.color = color;
    }

    public Ball(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public Ball(Location location, int radius, Color color) {
        this(location.getX(), location.getY(), radius, color);
    }

    public int getRadius() {
        return region.getWidth() / 2;
    }

    public Color getColor() {
        return color;
    }

    public Region getRegion() {
        return region;
    }
}

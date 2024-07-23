package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    static Logger log = LogManager.getLogger(Ball.class);

    int x;
    int y;
    int radius;
    Color color;

    public Ball(int x, int y, int radius, Color color) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public Ball(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMinX() {
        return x - radius;
    }

    public int getMaxX() {
        return x + radius;
    }

    public int getMinY() {
        return y - radius;
    }

    public int getMaxY() {
        return y + radius;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Rectangle getBounds() {
        return new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}

package com.nhnacademy;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box implements Regionable {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    static Logger log = LogManager.getLogger(Box.class);

    Region region;
    Color color;

    public Box(int x, int y, int width, int height, Color color) {
        if ((width < 0) || (height < 0)) {
            throw new IllegalArgumentException();
        }

        this.region = new Region(x, y, width, height);
        this.color = color;
    }

    public Box(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    public Color getColor() {
        return color;
    }

    public Region getRegion() {
        return region;
    }
}

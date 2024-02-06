package com.nhnacademy.exam070301;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable {
    public static final Color DEFAULT_COLOR = Color.RED;
    Color color;

    public PaintableBox(Point location, int width, int height, Color color) {
        super(location, width, height);

        this.color = color;
    }

    public PaintableBox(Point location, int width, int height) {
        this(location, width, height, DEFAULT_COLOR);
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException("Graphics context g is null");
        }

        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillRect(getMinX(), getMinY(), getWidth(), getWidth());
        g.setColor(previousColor);
    }
}

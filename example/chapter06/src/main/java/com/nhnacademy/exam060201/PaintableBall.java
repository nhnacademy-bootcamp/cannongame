package com.nhnacademy.exam060201;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    Color color;

    public PaintableBall(Point location, int radius, Color color) {
        super(location, radius);

        this.color = color;
    }

    public PaintableBall(Point location, int radius) {
        this(location, radius, DEFAULT_COLOR);
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
        g.fillOval(getRegion().getMinX(), getRegion().getMinY(), getRegion().getWidth(), getRegion().getWidth());
        g.setColor(previousColor);
    }
}

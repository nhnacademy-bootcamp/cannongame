package com.nhnacademy.exam070301;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball implements Paintable {
    public static final Color DEFAULT_COLOR = Color.BLUE;
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
        g.fillOval(getMinX(), getMinY(), getWidth(), getWidth());
        g.setColor(previousColor);
    }
}

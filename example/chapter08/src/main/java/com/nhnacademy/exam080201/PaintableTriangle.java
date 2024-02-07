package com.nhnacademy.exam080201;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableTriangle extends Triangle implements Paintable {
    public static final Color DEFAULT_COLOR = Color.GREEN;
    Color color;

    public PaintableTriangle(Point location, int width, int height, Color color) {
        super(location, width, height);

        this.color = color;
    }

    public PaintableTriangle(Point location, int width, int height) {
        this(location, width, height, DEFAULT_COLOR);
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException("Graphics context g is null");
        }

        int[] xs = { getLocation().getX(), getMinX(), getMaxX() };
        int[] ys = { getMaxY(), getMinY(), getMinY() };

        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillPolygon(xs, ys, xs.length);
        g.setColor(previousColor);
    }
}

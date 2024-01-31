package com.nhnacademy.exam030101;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    Color color;

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
    }

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
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
        g.fillOval(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
        g.setColor(previousColor);
    }
}

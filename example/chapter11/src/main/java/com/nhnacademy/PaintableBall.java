package com.nhnacademy;

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

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics graphics) {
        Color previousColor = graphics.getColor();

        graphics.setColor(color);
        graphics.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
        graphics.setColor(previousColor);
    }
}

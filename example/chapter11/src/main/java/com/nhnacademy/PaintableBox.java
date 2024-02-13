package com.nhnacademy;

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
        graphics.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
        graphics.setColor(previousColor);
    }
}

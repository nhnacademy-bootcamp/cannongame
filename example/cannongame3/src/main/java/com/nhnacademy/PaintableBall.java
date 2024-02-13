package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball implements Paintable {
    static final Color DEFAULT_COLOR = Color.GREEN;
    Color color = DEFAULT_COLOR;

    public PaintableBall(Point location, int radius) {
        super(location, radius);
    }

    public PaintableBall(Point location, int radius, Color color) {
        super(location, radius);

        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        Color previousColor = graphics.getColor();

        graphics.setColor(color);
        graphics.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
        graphics.setColor(previousColor);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof PaintableBall)
                && super.equals(other)
                && color == ((PaintableBall) other).getColor();

    }

}

package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public PaintableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new NullPointerException();
        }

        Color oldColor = g.getColor();

        g.setColor(getColor());
        g.fillOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
        g.setColor(oldColor);
    }
}

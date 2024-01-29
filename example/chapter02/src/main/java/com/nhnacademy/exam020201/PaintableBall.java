package com.nhnacademy.exam020201;

import java.awt.Color;
import java.awt.Graphics;

import com.nhnacademy.Ball;

public class PaintableBall extends Ball {
    Color color;

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
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

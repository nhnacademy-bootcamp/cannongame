package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable {
    public PaintableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public PaintableBox(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new NullPointerException();
        }

        Color oldColor = g.getColor();

        g.setColor(getColor());
        g.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(oldColor);
    }
}

package com.nhnacademy.exam020202;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 화면 출력 가능한 ball.
 */
public class PaintableBall extends Ball {
    Color color;

    /**
     * Constructor.
     *
     * @param x      X축 좌표
     * @param y      Y축 좌표
     * @param radius 반지름
     * @param color  색
     */
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Graphics context를 이용에 화면에 출력.
     *
     * @param g Graphics context
     */
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

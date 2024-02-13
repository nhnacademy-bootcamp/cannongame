package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class Cannon extends Region implements Paintable {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    Color color;
    int angle = 0;

    public Cannon(Point location, int width, int height, Color color) {
        super(location, width, height);

        this.color = color;
    }

    public Cannon(Point location, int width, int height) {
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

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Point getFirePit() {
        return new Point(
                (int) (getLocation().getX() + getWidth() * Math.cos(Math.toRadians(angle))),
                (int) (getLocation().getY() + getWidth() * Math.sin(Math.toRadians(angle))));
    }

    @Override
    public void paint(Graphics graphics) {
        int length = (int) Math.sqrt(Math.pow(getHeight() * 0.1, 2) + Math.pow(getWidth(), 2));
        double theta = Math.toDegrees(Math.atan(getHeight() * 0.1 / getWidth()));

        int[] xs = { (int) (getHeight() * 0.1 * Math.cos(Math.toRadians(-90.0 + angle))),
                (int) (length * Math.cos(Math.toRadians(-theta + angle))),
                (int) (length * Math.cos(Math.toRadians(theta + angle))),
                (int) (getHeight() * 0.1 * Math.cos(Math.toRadians(90.0 + angle))) };

        int[] ys = { (int) (getHeight() * 0.1 * Math.sin(Math.toRadians(-90.0 + angle))),
                (int) (length * Math.sin(Math.toRadians(-theta + angle))),
                (int) (length * Math.sin(Math.toRadians(theta + angle))),
                (int) (getHeight() * 0.1 * Math.sin(Math.toRadians(90.0 + angle))) };

        for (int i = 0; i < 4; i++) {
            xs[i] += getLocation().getX();
            ys[i] += getLocation().getY();
        }
        Color previousColor = graphics.getColor();

        graphics.setColor(color);
        graphics.fillOval(getLocation().getX() - (int) (getWidth() * 0.4),
                getLocation().getY() - (int) (getHeight() * 0.4),
                (int) (getWidth() * 0.8), (int) (getHeight() * 0.8));
        graphics.fillRect(getMinX(), getMinY(), getWidth(), getHeight() / 2);

        graphics.fillPolygon(xs, ys, xs.length);
        graphics.setColor(previousColor);
    }
}

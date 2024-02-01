package com.nhnacademy.exam040304;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getX() - ball.getRadius() < getBounds().getMinX())
                || (ball.getX() + ball.getRadius() > getBounds().getMaxX())
                || (ball.getY() - ball.getRadius() < getBounds().getMinY())
                || (ball.getY() + ball.getRadius() > getBounds().getMaxY());
    }

    public void bounceBall(MovableBall ball) {
        if (ball.getX() - ball.getRadius() < getBounds().getMinX()) {
            ball.moveTo((int) getBounds().getMinX() + ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());

        } else if (ball.getX() + ball.getRadius() > getBounds().getMaxX()) {
            ball.moveTo((int) getBounds().getMaxX() - ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());
        }

        if (ball.getY() - ball.getRadius() < getBounds().getMinY()) {
            ball.moveTo(ball.getX(), (int) getBounds().getMinY() + ball.getRadius());
            ball.setDY(-ball.getDY());
        } else if (ball.getY() + ball.getRadius() > getBounds().getMaxY()) {
            ball.moveTo(ball.getX(), (int) getBounds().getMaxY() - ball.getRadius());
            ball.setDY(-ball.getDY());
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Ball ball1 = get(i);

            if (ball1 instanceof MovableBall) {
                ((MovableBall) ball1).move();

                if (outOfBounds(ball1)) {
                    bounceBall((MovableBall) ball1);
                }

                for (int j = i + 1; j < getCount(); j++) {
                    Ball ball2 = get(j);

                    if (ball1.isCollision(ball2)) {
                        Rectangle intersection = ball1.getRegion().intersection(ball2.getRegion());

                        if ((intersection.getWidth() != ball1.getRegion().getWidth()) &&
                                (intersection.getWidth() != ball2.getRegion().getWidth())) {
                            if (ball1.getX() - ball1.getRadius() < ball2.getX() - ball2.getRadius()) {
                                int newX = 2 * (ball2.getX() - ball2.getRadius() + ball1.getRadius()) - ball1.getX();
                                ((MovableBall) ball1).moveTo(newX, ball1.getY());
                                ((MovableBall) ball1).setDX(-((MovableBall) ball1).getDX());
                            } else if (ball1.getX() + ball1.getRadius() > ball2.getX() + ball2.getRadius()) {
                                int newX = 2 * (ball2.getX() + ball2.getRadius() - ball1.getRadius()) - ball1.getX();
                                ((MovableBall) ball1).moveTo(newX, ball1.getY());
                                ((MovableBall) ball1).setDX(-((MovableBall) ball1).getDX());
                            }
                        }

                        if ((intersection.getHeight() != ball1.getRegion().getHeight()) &&
                                (intersection.getHeight() != ball2.getRegion().getHeight())) {
                            if (ball1.getY() - ball1.getRadius() < ball2.getY() - ball2.getRadius()) {
                                int newY = 2 * (ball2.getY() - ball2.getRadius() + ball1.getRadius()) - ball1.getY();
                                ((MovableBall) ball1).moveTo(ball1.getX(), newY);
                                ((MovableBall) ball1).setDY(-((MovableBall) ball1).getDY());
                            } else if (ball1.getY() + ball1.getRadius() > ball2.getY() + ball2.getRadius()) {
                                int newY = 2 * (ball2.getY() + ball2.getRadius() - ball1.getRadius()) - ball1.getY();
                                ((MovableBall) ball1).moveTo(ball1.getX(), newY);
                                ((MovableBall) ball1).setDY(-((MovableBall) ball1).getDY());
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

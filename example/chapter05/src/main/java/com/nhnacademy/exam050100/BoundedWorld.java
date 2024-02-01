package com.nhnacademy.exam050100;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getMinX() < getBounds().getMinX())
                || (ball.getMaxX() > getBounds().getMaxX())
                || (ball.getMinY() < getBounds().getMinY())
                || (ball.getMaxY() > getBounds().getMaxY());
    }

    public void bounceBall(MovableBall ball) {
        if (ball.getMinX() < getBounds().getMinX()) {
            ball.moveTo((int) getBounds().getMinX() + ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());

        } else if (ball.getMaxX() > getBounds().getMaxX()) {
            ball.moveTo((int) getBounds().getMaxX() - ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());
        }

        if (ball.getMinY() < getBounds().getMinY()) {
            ball.moveTo(ball.getX(), (int) getBounds().getMinY() + ball.getRadius());
            ball.setDY(-ball.getDY());
        } else if (ball.getMaxY() > getBounds().getMaxY()) {
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

                        if ((intersection.getWidth() != ball1.getWidth()) &&
                                (intersection.getWidth() != ball2.getWidth())) {
                            if (ball1.getMinX() < ball2.getMinX()) {
                                ((MovableBall) ball1).moveTo(2 * ball2.getMinX() - ball1.getMinX() + ball1.getRadius(),
                                        ball1.getY());
                                ((MovableBall) ball1).setDX(-((MovableBall) ball1).getDX());
                            } else if (ball1.getMaxX() > ball2.getMaxX()) {
                                ((MovableBall) ball1).moveTo(2 * ball2.getMaxX() - ball1.getMaxX() - ball1.getRadius(),
                                        ball1.getY());
                                ((MovableBall) ball1).setDX(-((MovableBall) ball1).getDX());
                            }
                        }

                        if ((intersection.getHeight() != ball1.getHeight()) &&
                                (intersection.getHeight() != ball2.getHeight())) {
                            if (ball1.getMinY() < ball2.getMinY()) {
                                ((MovableBall) ball1).moveTo(ball1.getX(),
                                        2 * ball2.getMinY() - ball1.getMinY() + ball1.getRadius());
                                ((MovableBall) ball1).setDY(-((MovableBall) ball1).getDY());
                            } else if (ball1.getMaxY() > ball2.getMaxY()) {
                                ((MovableBall) ball1).moveTo(ball1.getX(),
                                        2 * ball2.getMaxY() - ball1.getMaxY() - ball1.getRadius());
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

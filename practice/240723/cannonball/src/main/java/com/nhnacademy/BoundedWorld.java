package com.nhnacademy;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getMinX() < getBounds().getMinX())
                || ball.getMaxX() > getBounds().getMaxX()
                || ball.getMinY() < getBounds().getMinY()
                || ball.getMaxY() > getBounds().getMaxY();
    }

    public void bounceBall(MovableBall ball) {
        if (outOfBounds(ball)) {
            if ((ball.getMinX() < getBounds().getMinX()) || (ball.getMaxX() > getBounds().getMaxX())) {
                ball.setDX(-ball.getDX());
            }

            if ((ball.getMinY() < getBounds().getMinY()) || (ball.getMaxY() > getBounds().getMaxY())) {
                ball.setDY(-ball.getDY());
            }
        }
    }

    @Override
    public void move() {
        super.move();

        for (int i = 0; i < getBallCount(); i++) {
            Ball ball = getBall(i);

            if (ball instanceof MovableBall) {
                for (int j = 0; j < getBallCount(); j++) {
                    Ball otherBall = getBall(j);

                    if ((ball != otherBall) && (ball.getBounds().intersects(otherBall.getBounds()))) {
                        Rectangle itersection = ball.getBounds().intersection(otherBall.getBounds());

                        if (ball.getBounds().getWidth() < otherBall.getBounds().getWidth()) {
                            if (itersection.getWidth() < ball.getBounds().getWidth()) {
                                ((MovableBall) ball).setDX(-((MovableBall) ball).getDX());
                            }

                            if (itersection.getHeight() < ball.getBounds().getHeight()) {
                                ((MovableBall) ball).setDY(-((MovableBall) ball).getDY());
                            }

                        } else {
                            if (itersection.getWidth() < otherBall.getBounds().getWidth()) {
                                ((MovableBall) ball).setDX(-((MovableBall) ball).getDX());
                            }

                            if (itersection.getHeight() < otherBall.getBounds().getHeight()) {
                                ((MovableBall) ball).setDY(-((MovableBall) ball).getDY());
                            }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < getBallCount(); i++) {
            Ball ball = getBall(i);
            if (ball instanceof MovableBall) {
                bounceBall((MovableBall) ball);
            }
        }
    }
}

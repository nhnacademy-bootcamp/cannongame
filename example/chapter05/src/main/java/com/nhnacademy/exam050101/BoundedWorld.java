package com.nhnacademy.exam050101;

import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getRegion().getMinX() < getBounds().getMinX())
                || (ball.getRegion().getMaxX() > getBounds().getMaxX())
                || (ball.getRegion().getMinY() < getBounds().getMinY())
                || (ball.getRegion().getMaxY() > getBounds().getMaxY());
    }

    public void bounceBall(MovableBall ball) {
        if (ball.getRegion().getMinX() < getBounds().getMinX()) {
            ball.moveTo(new Point(
                    (int) (2 * (getBounds().getMinX() + ball.getRadius()) - ball.getLocation().getX()
                            + Math.abs(ball.getDX())),
                    ball.getLocation().getY()));
            ball.setDX(Math.abs(ball.getDX()));

        } else if (ball.getRegion().getMaxX() > getBounds().getMaxX()) {
            ball.moveTo(new Point(
                    (int) (2 * (getBounds().getMaxX() - ball.getRadius()) - ball.getLocation().getX()
                            - Math.abs(ball.getDX())),
                    ball.getLocation().getY()));
            ball.setDX(-Math.abs(ball.getDX()));
        }

        if (ball.getRegion().getMinY() < getBounds().getMinY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMinY() + ball.getRadius()) - ball.getLocation().getY()
                            + Math.abs(ball.getDY()))));
            ball.setDY(Math.abs(ball.getDY()));
        } else if (ball.getRegion().getMaxY() > getBounds().getMaxY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMaxY() - ball.getRadius()) - ball.getLocation().getY()
                            - Math.abs(ball.getDY()))));
            ball.setDY(-Math.abs(ball.getDY()));
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getCount(); i++) {

            if (get(i) instanceof MovableBall) {
                MovableBall ball1 = (MovableBall) get(i);

                ball1.move();

                if (outOfBounds(ball1)) {
                    bounceBall(ball1);
                }

                for (int j = 01; j < getCount(); j++) {
                    if (ball1 != get(j)) {
                        Ball ball2 = get(j);

                        if (ball1.isCollision(ball2)) {
                            Rectangle intersection = ball1.getRegion().intersection(ball2.getRegion());

                            if ((intersection.getWidth() != ball1.getRegion().getWidth()) &&
                                    (intersection.getWidth() != ball2.getRegion().getWidth())) {
                                if (ball1.getRegion().getMinX() < ball2.getRegion().getMinX()) {
                                    ball1.moveTo(new Point(
                                            (int) (2 * (ball2.getRegion().getMinX() + ball1.getRadius())
                                                    - ball1.getLocation().getX()),
                                            ball1.getLocation().getY()));
                                    ball1.setDY(-Math.abs(ball1.getDX()));
                                } else if (ball1.getRegion().getMaxX() > ball2.getRegion().getMaxX()) {
                                    ball1.moveTo(new Point(
                                            (int) (2 * (ball2.getRegion().getMaxX() - ball1.getRadius())
                                                    - ball1.getLocation().getX()),
                                            ball1.getLocation().getY()));
                                    ball1.setDY(Math.abs(ball1.getDX()));
                                }
                            }

                            if ((intersection.getHeight() != ball1.getRegion().getHeight()) &&
                                    (intersection.getHeight() != ball2.getRegion().getHeight())) {
                                if (ball1.getRegion().getMinY() < ball2.getRegion().getMinY()) {
                                    ball1.moveTo(new Point(ball1.getLocation().getX(),
                                            (int) (2 * (ball2.getRegion().getMinY() + ball1.getRadius()
                                                    - ball1.getLocation().getY()))));
                                    ball1.setDY(-Math.abs(ball1.getDY()));
                                } else if (ball1.getRegion().getMaxY() > ball2.getRegion().getMaxY()) {
                                    ball1.moveTo(new Point(ball1.getLocation().getX(),
                                            (int) (2 * (ball2.getRegion().getMaxY() - ball1.getRadius()
                                                    - ball1.getLocation().getY()))));
                                    ball1.setDY(Math.abs(ball1.getDY()));
                                }
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

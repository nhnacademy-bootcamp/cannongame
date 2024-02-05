package com.nhnacademy.exam060101;

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
                            + Math.abs(ball.getMotion().getDX())),
                    ball.getLocation().getY()));
            ball.getMotion().turnDX();

        } else if (ball.getRegion().getMaxX() > getBounds().getMaxX()) {
            ball.moveTo(new Point(
                    (int) (2 * (getBounds().getMaxX() - ball.getRadius()) - ball.getLocation().getX()
                            - Math.abs(ball.getMotion().getDX())),
                    ball.getLocation().getY()));
            ball.getMotion().turnDX();
        }

        if (ball.getRegion().getMinY() < getBounds().getMinY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMinY() + ball.getRadius()) - ball.getLocation().getY()
                            + Math.abs(ball.getMotion().getDY()))));
            ball.getMotion().turnDY();
        } else if (ball.getRegion().getMaxY() > getBounds().getMaxY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMaxY() - ball.getRadius()) - ball.getLocation().getY()
                            - Math.abs(ball.getMotion().getDY()))));
            ball.getMotion().turnDY();
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

                for (int j = 0; j < getCount(); j++) {
                    if (ball1 != get(j)) {
                        Ball ball2 = get(j);

                        if (ball1.isCollision(ball2)) {
                            Region intersection = ball1.getRegion().intersection(ball2.getRegion());

                            if ((intersection.getWidth() != ball1.getRegion().getWidth()) &&
                                    (intersection.getWidth() != ball2.getRegion().getWidth())) {
                                ball1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball1.getRegion().getHeight()) &&
                                    (intersection.getHeight() != ball2.getRegion().getHeight())) {
                                ball1.getMotion().turnDY();
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

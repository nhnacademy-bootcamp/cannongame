package com.nhnacademy.exam060301;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getRegion().getMinX() < getBounds().getMinX())
                || (ball.getRegion().getMaxX() > getBounds().getMaxX())
                || (ball.getRegion().getMinY() < getBounds().getMinY())
                || (ball.getRegion().getMaxY() > getBounds().getMaxY());
    }

    public boolean outOfBounds(Box box) {
        return (box.getRegion().getMinX() < getBounds().getMinX())
                || (box.getRegion().getMaxX() > getBounds().getMaxX())
                || (box.getRegion().getMinY() < getBounds().getMinY())
                || (box.getRegion().getMaxY() > getBounds().getMaxY());
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

    public void bounceBox(MovableBox ball) {
        if ((ball.getRegion().getMinX() < getBounds().getMinX()) ||
                (ball.getRegion().getMaxX() > getBounds().getMaxX())) {
            ball.getMotion().turnDX();
        }

        if ((ball.getRegion().getMinY() < getBounds().getMinY()) ||
                (ball.getRegion().getMaxY() > getBounds().getMaxY())) {
            ball.getMotion().turnDY();
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getBallCount(); i++) {
            if (getBall(i) instanceof MovableBall) {
                MovableBall ball1 = (MovableBall) getBall(i);

                ball1.move();

                if (outOfBounds(ball1)) {
                    bounceBall(ball1);
                }

                for (int j = 0; j < getBallCount(); j++) {
                    if (ball1 != getBall(j)) {
                        Ball ball2 = getBall(j);

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

                for (int j = 0; j < getBoxCount(); j++) {
                    Box box = getBox(j);

                    if (ball1.isCollision(box)) {
                        Region intersection = ball1.getRegion().intersection(box.getRegion());

                        if ((intersection.getWidth() != ball1.getRegion().getWidth()) &&
                                (intersection.getWidth() != box.getRegion().getWidth())) {
                            ball1.getMotion().turnDX();
                        }

                        if ((intersection.getHeight() != ball1.getRegion().getHeight()) &&
                                (intersection.getHeight() != box.getRegion().getHeight())) {
                            ball1.getMotion().turnDY();
                        }
                    }
                }

            }
        }

        for (int i = 0; i < getBoxCount(); i++) {
            if (getBox(i) instanceof MovableBox) {
                MovableBox box1 = (MovableBox) getBox(i);

                box1.move();

                if (outOfBounds(box1)) {
                    bounceBox(box1);
                }

                for (int j = 0; j < getBoxCount(); j++) {
                    if (box1 != getBox(j)) {
                        Box box2 = getBox(j);

                        if (box1.isCollision(box2)) {
                            Region intersection = box1.getRegion().intersection(box2.getRegion());

                            if ((intersection.getWidth() != box1.getRegion().getWidth()) &&
                                    (intersection.getWidth() != box2.getRegion().getWidth())) {
                                box1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != box1.getRegion().getHeight()) &&
                                    (intersection.getHeight() != box2.getRegion().getHeight())) {
                                box1.getMotion().turnDY();
                            }
                        }
                    }
                }

                for (int j = 0; j < getBallCount(); j++) {
                    Ball ball = getBall(j);

                    if (box1.isCollision(ball)) {
                        Region intersection = box1.getRegion().intersection(ball.getRegion());

                        if ((intersection.getWidth() != box1.getRegion().getWidth()) &&
                                (intersection.getWidth() != ball.getRegion().getWidth())) {
                            box1.getMotion().turnDX();
                        }

                        if ((intersection.getHeight() != box1.getRegion().getHeight()) &&
                                (intersection.getHeight() != ball.getRegion().getHeight())) {
                            box1.getMotion().turnDY();
                        }
                    }
                }

            }
        }

        repaint();
    }
}

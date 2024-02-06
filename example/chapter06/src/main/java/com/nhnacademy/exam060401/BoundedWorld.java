package com.nhnacademy.exam060401;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Region region) {
        return (region.getMinX() < getBounds().getMinX())
                || (region.getMaxX() > getBounds().getMaxX())
                || (region.getMinY() < getBounds().getMinY())
                || (region.getMaxY() > getBounds().getMaxY());
    }

    public void bounce(MovableBall ball) {
        if (ball.getMinX() < getBounds().getMinX()) {
            ball.moveTo(new Point(
                    (int) (2 * (getBounds().getMinX() + ball.getRadius()) - ball.getLocation().getX()
                            + Math.abs(ball.getMotion().getDX())),
                    ball.getLocation().getY()));
            ball.getMotion().turnDX();

        } else if (ball.getMaxX() > getBounds().getMaxX()) {
            ball.moveTo(new Point(
                    (int) (2 * (getBounds().getMaxX() - ball.getRadius()) - ball.getLocation().getX()
                            - Math.abs(ball.getMotion().getDX())),
                    ball.getLocation().getY()));
            ball.getMotion().turnDX();
        }

        if (ball.getMinY() < getBounds().getMinY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMinY() + ball.getRadius()) - ball.getLocation().getY()
                            + Math.abs(ball.getMotion().getDY()))));
            ball.getMotion().turnDY();
        } else if (ball.getMaxY() > getBounds().getMaxY()) {
            ball.moveTo(new Point(
                    ball.getLocation().getX(),
                    (int) (2 * (getBounds().getMaxY() - ball.getRadius()) - ball.getLocation().getY()
                            - Math.abs(ball.getMotion().getDY()))));
            ball.getMotion().turnDY();
        }
    }

    public void bounceBox(MovableBox ball) {
        if ((ball.getMinX() < getBounds().getMinX()) ||
                (ball.getMaxX() > getBounds().getMaxX())) {
            ball.getMotion().turnDX();
        }

        if ((ball.getMinY() < getBounds().getMinY()) ||
                (ball.getMaxY() > getBounds().getMaxY())) {
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
                    bounce(ball1);
                }

                for (int j = 0; j < getCount(); j++) {
                    if ((get(j) instanceof Ball) && (ball1 != get(j))) {
                        Ball ball2 = (Ball) get(j);

                        if (ball1.isCollision(ball2)) {
                            Region intersection = ball1.intersection(ball2);

                            if ((intersection.getWidth() != ball1.getWidth()) &&
                                    (intersection.getWidth() != ball2.getWidth())) {
                                ball1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball1.getHeight()) &&
                                    (intersection.getHeight() != ball2.getHeight())) {
                                ball1.getMotion().turnDY();
                            }
                        }
                    }
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) instanceof Box) {
                        Box box = (Box) get(j);

                        if (ball1.isCollision(box)) {
                            Region intersection = ball1.intersection(box);

                            if ((intersection.getWidth() != ball1.getWidth()) &&
                                    (intersection.getWidth() != box.getWidth())) {
                                ball1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball1.getHeight()) &&
                                    (intersection.getHeight() != box.getHeight())) {
                                ball1.getMotion().turnDY();
                            }
                        }
                    }
                }

            }
        }

        for (int i = 0; i < getCount(); i++) {
            if (get(i) instanceof MovableBox) {
                MovableBox box1 = (MovableBox) get(i);

                box1.move();

                if (outOfBounds(box1)) {
                    bounceBox(box1);
                }

                for (int j = 0; j < getCount(); j++) {
                    if ((box1 != get(j)) && (get(j) instanceof Box)) {
                        Box box2 = (Box) get(j);

                        if (box1.isCollision(box2)) {
                            Region intersection = box1.intersection(box2);

                            if ((intersection.getWidth() != box1.getWidth()) &&
                                    (intersection.getWidth() != box2.getWidth())) {
                                box1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != box1.getHeight()) &&
                                    (intersection.getHeight() != box2.getHeight())) {
                                box1.getMotion().turnDY();
                            }
                        }
                    }
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) instanceof Ball) {
                        Ball ball = (Ball) get(j);

                        if (box1.isCollision(ball)) {
                            Region intersection = box1.intersection(ball);

                            if ((intersection.getWidth() != box1.getWidth()) &&
                                    (intersection.getWidth() != ball.getWidth())) {
                                box1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != box1.getHeight()) &&
                                    (intersection.getHeight() != ball.getHeight())) {
                                box1.getMotion().turnDY();
                            }
                        }
                    }
                }

            }
        }

        repaint();
    }
}

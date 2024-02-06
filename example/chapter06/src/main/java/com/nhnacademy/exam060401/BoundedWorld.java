package com.nhnacademy.exam060401;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Region object) {
        return (object.getMinX() < getBounds().getMinX())
                || (object.getMaxX() > getBounds().getMaxX())
                || (object.getMinY() < getBounds().getMinY())
                || (object.getMaxY() > getBounds().getMaxY());
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

    public void bounce(MovableBox ball) {
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
            if ((get(i) instanceof MovableBall) || (get(i) instanceof MovableBox)) {
                Region object = get(i);

                if (object instanceof MovableBall) {
                    ((MovableBall) object).move();
                } else if (object instanceof MovableBox) {
                    ((MovableBox) object).move();
                }

                if (outOfBounds(object)) {
                    if (object instanceof MovableBall) {
                        bounce((MovableBall) object);
                    } else if (object instanceof MovableBox) {
                        bounce((MovableBox) object);
                    }
                }

                for (int j = 0; j < getCount(); j++) {
                    if (object != get(j)) {
                        Region ball2 = get(j);

                        if (object.intersects(ball2)) {
                            Region intersection = object.intersection(ball2);

                            if ((intersection.getWidth() != object.getWidth()) &&
                                    (intersection.getWidth() != ball2.getWidth())) {
                                if (object instanceof MovableBall) {
                                    ((MovableBall) object).getMotion().turnDX();
                                } else if (object instanceof MovableBox) {
                                    ((MovableBox) object).getMotion().turnDX();
                                }
                            }

                            if ((intersection.getHeight() != object.getHeight()) &&
                                    (intersection.getHeight() != ball2.getHeight())) {
                                if (object instanceof MovableBall) {
                                    ((MovableBall) object).getMotion().turnDY();
                                } else if (object instanceof MovableBox) {
                                    ((MovableBox) object).getMotion().turnDY();
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

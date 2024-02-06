package com.nhnacademy.exam070201;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Regionable regionable) {
        return (regionable.getMinX() < getBounds().getMinX())
                || (regionable.getMaxX() > getBounds().getMaxX())
                || (regionable.getMinY() < getBounds().getMinY())
                || (regionable.getMaxY() > getBounds().getMaxY());
    }

    public void bounce(MovableBall ball) {
        if ((ball.getMinX() < getBounds().getMinX())
                || (ball.getMaxX() > getBounds().getMaxX())) {
            ball.getMotion().turnDX();
        }

        if ((ball.getMinY() < getBounds().getMinY())
                || (ball.getMaxY() > getBounds().getMaxY())) {
            ball.getMotion().turnDY();
        }
    }

    public void bounce(MovableBox box) {
        if ((box.getMinX() < getBounds().getMinX())
                || (box.getMaxX() > getBounds().getMaxX())) {
            box.getMotion().turnDX();
        }

        if ((box.getMinY() < getBounds().getMinY())
                || (box.getMaxY() > getBounds().getMaxY())) {
            box.getMotion().turnDY();
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getCount(); i++) {
            if (get(i) instanceof MovableBall) {
                MovableBall ball = (MovableBall) get(i);

                ball.move();

                if (outOfBounds(ball)) {
                    bounce(ball);
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) != ball) {
                        Regionable regionable = get(j);

                        if (ball.intersects(regionable)) {
                            Regionable intersection = ball.intersection(regionable);

                            if ((intersection.getWidth() != ball.getWidth()) &&
                                    (intersection.getWidth() != regionable.getWidth())) {
                                ball.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball.getHeight()) &&
                                    (intersection.getHeight() != regionable.getHeight())) {
                                ball.getMotion().turnDY();
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < getCount(); i++) {
            if (get(i) instanceof MovableBox) {
                MovableBox box = (MovableBox) get(i);

                box.move();

                if (outOfBounds(box)) {
                    bounce(box);
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) != box) {
                        Regionable regionable = get(j);

                        if (box.intersects(regionable)) {
                            Regionable intersection = box.intersection(regionable);

                            if ((intersection.getWidth() != box.getWidth()) &&
                                    (intersection.getWidth() != regionable.getWidth())) {
                                box.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != box.getHeight()) &&
                                    (intersection.getHeight() != regionable.getHeight())) {
                                box.getMotion().turnDY();
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

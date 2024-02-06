package com.nhnacademy.exam070401;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Regionable regionable) {
        return (regionable.getMinX() < getBounds().getMinX())
                || (regionable.getMaxX() > getBounds().getMaxX())
                || (regionable.getMinY() < getBounds().getMinY())
                || (regionable.getMaxY() > getBounds().getMaxY());
    }

    public void bounce(Movable object) {
        if ((object.getMinX() < getBounds().getMinX())
                || (object.getMaxX() > getBounds().getMaxX())) {
            object.getMotion().turnDX();
        }

        if ((object.getMinY() < getBounds().getMinY())
                || (object.getMaxY() > getBounds().getMaxY())) {
            object.getMotion().turnDY();
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getCount(); i++) {
            if (get(i) instanceof Movable) {
                Movable object = (Movable) get(i);

                object.move();

                if (outOfBounds(object)) {
                    bounce(object);
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) != object) {
                        Regionable regionable = get(j);

                        if (object.intersects(regionable)) {
                            Regionable intersection = object.intersection(regionable);

                            if ((intersection.getWidth() != object.getWidth()) &&
                                    (intersection.getWidth() != regionable.getWidth())) {
                                object.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != object.getHeight()) &&
                                    (intersection.getHeight() != regionable.getHeight())) {
                                object.getMotion().turnDY();
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

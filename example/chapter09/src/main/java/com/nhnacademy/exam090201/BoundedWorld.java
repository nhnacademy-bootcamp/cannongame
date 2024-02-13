package com.nhnacademy.exam090201;

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

                for (Motion effect : effectList) {
                    object.addEffect(effect);
                }

                object.move();

                if (outOfBounds(object)) {
                    bounce(object);
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) != object) {
                        Regionable regionable = get(j);

                        if (object.intersects(regionable)) {
                            boolean bounded = false;
                            Regionable intersection = object.intersection(regionable);

                            if ((intersection.getWidth() != object.getWidth()) &&
                                    (intersection.getWidth() != regionable.getWidth())) {
                                object.getMotion().turnDX();

                                if (object.getMinX() < intersection.getMinX()) {
                                    object.moveTo(new Point(
                                            intersection.getMinX() - object.getWidth() / 2,
                                            object.getLocation().getY()));
                                } else if (object.getMaxX() > intersection.getMaxX()) {
                                    object.moveTo(new Point(
                                            intersection.getMaxX() + object.getWidth() / 2,
                                            object.getLocation().getY()));
                                }
                                bounded = true;
                            }

                            if ((intersection.getHeight() != object.getHeight()) &&
                                    (intersection.getHeight() != regionable.getHeight())) {
                                object.getMotion().turnDY();
                                if (object.getMinY() < intersection.getMinY()) {
                                    object.moveTo(new Point(
                                            object.getLocation().getX(),
                                            intersection.getMinY() - object.getHeight() / 2));
                                } else if (object.getMaxY() > intersection.getMaxY()) {
                                    object.moveTo(new Point(
                                            object.getLocation().getX(),
                                            intersection.getMaxY() + object.getHeight() / 2));
                                }
                                bounded = true;
                            }

                            if (bounded && (object instanceof Bounded)) {
                                ((Bounded) object).applyCOR(regionable.getCOR());
                            }
                        }
                    }
                }
            }
        }

        repaint();
    }
}

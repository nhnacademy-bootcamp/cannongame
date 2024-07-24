package com.nhnacademy;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Regionable object) {
        return (object.getMinX() < getBounds().getMinX())
                || object.getMaxX() > getBounds().getMaxX()
                || object.getMinY() < getBounds().getMinY()
                || object.getMaxY() > getBounds().getMaxY();
    }

    public void bounce(Movable object) {
        if (outOfBounds(object)) {
            if ((object.getMinX() < getBounds().getMinX()) || (object.getMaxX() > getBounds().getMaxX())) {
                object.getMotion().turnDX();
            }

            if ((object.getMinY() < getBounds().getMinY()) || (object.getMaxY() > getBounds().getMaxY())) {
                object.getMotion().turnDY();
            }
        }
    }

    @Override
    public void move() {
        super.move();

        for (int i = 0; i < getCount(); i++) {
            Regionable object = get(i);

            if (object instanceof Movable) {
                for (int j = 0; j < getCount(); j++) {
                    Regionable other = get(j);

                    if ((object != other) && (object.intersects(other))) {
                        Region itersection = object.intersection(other);

                        if (object.getWidth() < other.getWidth()) {
                            if (itersection.getWidth() < object.getWidth()) {
                                ((Movable) object).getMotion().turnDX();
                            }

                            if (itersection.getHeight() < object.getHeight()) {
                                ((Movable) object).getMotion().turnDY();
                            }

                        } else {
                            if (itersection.getWidth() < other.getWidth()) {
                                ((Movable) object).getMotion().turnDX();
                            }

                            if (itersection.getHeight() < other.getHeight()) {
                                ((Movable) object).getMotion().turnDY();
                            }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < getCount(); i++) {
            Regionable object = get(i);
            if (object instanceof Movable) {
                bounce((Movable) object);
            }
        }
    }
}

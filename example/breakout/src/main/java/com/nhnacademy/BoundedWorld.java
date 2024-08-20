package com.nhnacademy;

public class BoundedWorld extends MovableWorld {

    public boolean outOfBounds(Bounded bounded) {
        return bounded.getMinX() < getBounds().getMinX()
                || bounded.getMaxX() > getBounds().getMaxX()
                || bounded.getMinY() < getBounds().getMinY()
                || bounded.getMaxY() > getBounds().getMaxY();
    }

    public void bounce(Bounded bounded) {
        if (bounded instanceof MovableBall) {
            if (bounded.getMinX() < getBounds().getMinX()
                    || bounded.getMaxX() > getBounds().getMaxX()) {
                ((MovableBall) bounded).setDX(-((MovableBall) bounded).getDX());
            }
            if (bounded.getMinY() < getBounds().getMinY()
                    || bounded.getMaxY() > getBounds().getMaxY()) {
                ((MovableBall) bounded).setDY(-((MovableBall) bounded).getDY());
            }
        }

    }

    @Override
    public void move() {
        super.move();

        for (int i = 0; i < getCount(); i++) {
            Bounded bounded = get(i);

            if (bounded instanceof MovableBall) {
                if (outOfBounds(bounded)) {
                    bounce(bounded);
                }

                for (int j = 0; j < getCount(); j++) {
                    if (i != j) {
                        Bounded other = get(j);

                        if (bounded.getBounds().intersects(other.getBounds())) {
                            ((Movable) bounded).bounce(other);
                        }
                    }
                }
            }
        }
    }
}

package com.nhnacademy;

public class BoundedWorld extends MovableWorld {
    @Override
    public void move(Movable movable) {
        super.move(movable);

        if (movable instanceof Bounded) {
            for (int i = 0; i < getObjectCount(); i++) {
                ((Bounded) movable).bounce(getObject(i));
            }
        }
    }
}

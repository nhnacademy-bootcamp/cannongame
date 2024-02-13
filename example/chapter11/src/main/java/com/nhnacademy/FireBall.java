package com.nhnacademy;

import java.awt.Color;

public class FireBall extends BoundedBall {
    BurstAction action;

    public FireBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public FireBall(Point location, int radius) {
        super(location, radius);
    }

    public void setAction(BurstAction action) {
        this.action = action;
    }

    @Override
    public void bounce(Regionable obstacle) {
        if (isCollision(obstacle)) {
            if ((obstacle instanceof Burstable) && (action != null)) {
                action.burst(obstacle);
            } else {
                super.bounce(obstacle);
            }
        }
    }
}

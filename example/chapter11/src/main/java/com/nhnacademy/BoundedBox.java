package com.nhnacademy;

import java.awt.Color;

public class BoundedBox extends MovableBox implements Bounded {
    public BoundedBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);
    }

    public BoundedBox(Point location, int width, int height) {
        super(location, width, height);
    }

    public void bounce(Regionable obstacle) {
        if (isCollision(obstacle)) {
            Region intersection = getIntersection(obstacle);
            boolean bounded = false;

            if ((getWidth() != intersection.getWidth())
                    && (obstacle.getWidth() != intersection.getWidth())) {
                turnX();
                bounded = true;
            }

            if ((getHeight() != intersection.getHeight())
                    && (obstacle.getHeight() != intersection.getHeight())) {
                turnY();
                bounded = true;
            }

            if (bounded) {
                double newCor = getCOR() * obstacle.getCOR();
                getDisplacement().multiply(newCor);
                if (newCor == 0) {
                    stop();
                }
            }
        }
    }
}

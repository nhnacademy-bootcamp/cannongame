package com.nhnacademy;

import java.awt.Color;

public class BoundedBall extends MovableBall implements Bounded {
    public BoundedBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public BoundedBall(Point location, int radius) {
        super(location, radius);
    }

    public void bounce(Regionable obstacle) {
        if (isCollision(obstacle)) {
            Region intersection = getIntersection(obstacle);
            boolean bounded = false;

            if ((getWidth() != intersection.getWidth())
                    && (obstacle.getWidth() != intersection.getWidth())) {
                if (getMinX() < obstacle.getMinX()) {
                    moveTo(new Point(obstacle.getMinX() - getWidth() / 2, getCenterY()));
                } else {
                    moveTo(new Point(obstacle.getMaxX() + getWidth() / 2, getCenterY()));
                }
                turnX();
                bounded = true;
            }

            if ((getHeight() != intersection.getHeight())
                    && (obstacle.getHeight() != intersection.getHeight())) {
                if (getMinY() < obstacle.getMinY()) {
                    moveTo(new Point(getCenterX(), obstacle.getMinY() - getHeight() / 2));
                } else {
                    moveTo(new Point(getCenterX(), obstacle.getMaxY() + getHeight() / 2));
                }
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

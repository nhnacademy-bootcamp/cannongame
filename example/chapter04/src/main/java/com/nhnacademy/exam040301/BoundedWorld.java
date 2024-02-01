package com.nhnacademy.exam040301;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Ball ball) {
        return (ball.getX() - ball.getRadius() < getBounds().getMinX())
                || (ball.getX() + ball.getRadius() > getBounds().getMaxX())
                || (ball.getY() - ball.getRadius() < getBounds().getMinY())
                || (ball.getY() + ball.getRadius() > getBounds().getMaxY());
    }

    public void bounceBall(MovableBall ball) {
        if (ball.getX() - ball.getRadius() < getBounds().getMinX()) {
            ball.moveTo((int) getBounds().getMinX() + ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());

        } else if (ball.getX() + ball.getRadius() > getBounds().getMaxX()) {
            ball.moveTo((int) getBounds().getMaxX() - ball.getRadius(), ball.getY());
            ball.setDX(-ball.getDX());
        }

        if (ball.getY() - ball.getRadius() < getBounds().getMinY()) {
            ball.moveTo(ball.getX(), (int) getBounds().getMinY() + ball.getRadius());
            ball.setDY(-ball.getDY());
        } else if (ball.getY() + ball.getRadius() > getBounds().getMaxY()) {
            ball.moveTo(ball.getX(), (int) getBounds().getMaxY() - ball.getRadius());
            ball.setDY(-ball.getDY());
        }
    }

    @Override
    public void move() {
        super.move();

        for (int i = 0; i < getCount(); i++) {
            Ball ball = get(i);

            if ((ball instanceof MovableBall) && (outOfBounds(ball))) {
                bounceBall((MovableBall) ball);
            }
        }
    }
}

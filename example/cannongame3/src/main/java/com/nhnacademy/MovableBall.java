package com.nhnacademy;

public class MovableBall extends PaintableBall implements Movable {
    final Vector displacement = new DisplacementVector(0, 0);

    public MovableBall(Point location, int radius) {
        super(location, radius);
    }

    @Override
    public void setDisplacement(Vector displacement) {
        this.displacement.set(displacement);
    }

    @Override
    public Vector getDisplacement() {
        return displacement;
    }

    @Override
    public void move() {
        translate(displacement.getDX(), displacement.getDY());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof MovableBall)
                && super.equals(other)
                && displacement.equals(((MovableBall) other).getDisplacement());
    }
}

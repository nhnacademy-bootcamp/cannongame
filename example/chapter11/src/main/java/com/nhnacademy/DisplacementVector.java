package com.nhnacademy;

public class DisplacementVector extends Vector {

    public DisplacementVector(int magnitude, int angle) {
        super((int) (magnitude * Math.cos(Math.toRadians(angle))),
                (int) (magnitude * Math.sin(Math.toRadians(angle))));
    }
}

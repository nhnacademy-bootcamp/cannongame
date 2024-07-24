package com.nhnacademy;

public class DisplacementVector extends Vector {

    public DisplacementVector(int angle, int magnitude) {
        super((int) (magnitude * Math.cos(Math.toRadians(angle))),
                (int) (magnitude * Math.sin(Math.toRadians(angle))));
    }
}

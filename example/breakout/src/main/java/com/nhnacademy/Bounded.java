package com.nhnacademy;

import java.awt.Rectangle;

public interface Bounded {
    Rectangle getBounds();

    int getMinX();

    int getMaxX();

    int getMinY();

    int getMaxY();

    int getWidth();

    int getHeight();
}

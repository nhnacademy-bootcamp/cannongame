package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public interface Paintable {
    public Color getColor();

    public void setColor(Color color);

    /**
     * 주어진 graphics context를 이용해 형태를 그린다.
     *
     * @param graphics Graphics context
     */
    public void paint(Graphics graphics);
}

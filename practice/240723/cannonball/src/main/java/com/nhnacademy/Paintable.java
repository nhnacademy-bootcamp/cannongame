package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public interface Paintable {
    Color getColor();

    void paint(Graphics g);
}

package com.nhnacademy;

import java.awt.Color;

public class TargetBox extends PaintableBox implements Burstable {
    BurstAction action;

    public TargetBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);

        setCOR(0);
    }

    public TargetBox(Point location, int width, int height) {
        this(location, width, height, Color.YELLOW);
    }

    public void setAction(BurstAction action) {
        this.action = action;
    }

    public void explode(Regionable bomb) {
        if (action != null) {
            action.burst(bomb);
        }
    }
}

package com.nhnacademy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class World extends JPanel {
    List<Bounded> boundedList;

    public World() {
        super();
        boundedList = new ArrayList<>();
    }

    public void add(Bounded bounded) {
        if (bounded == null) {
            throw new IllegalArgumentException();
        }

        if ((getWidth() < bounded.getMaxX()) || (bounded.getMinX() < 0)
                || (getHeight() < bounded.getMaxY()) || (bounded.getMinY() < 0)) {
            throw new IllegalArgumentException("ball이 world를 벗어 났습니다.");
        }

        boundedList.add(bounded);
    }

    public void remove(Ball ball) {
        boundedList.remove(ball);
    }

    public void remove(int index) {
        boundedList.remove(index);
    }

    public int getCount() {
        return boundedList.size();
    }

    public Bounded get(int index) {
        return boundedList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Bounded bounded : boundedList) {
            if (bounded instanceof Paintable) {
                ((Paintable) bounded).paint(g);
            }
        }
    }
}

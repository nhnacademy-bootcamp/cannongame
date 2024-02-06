package com.nhnacademy.exam070301;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Regionable> regionableList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Regionable object) {
        for (Regionable item : regionableList) {
            if (item.intersects(object)) {
                throw new IllegalArgumentException();
            }
        }

        if ((object.getMinX() < 0) || (getWidth() < object.getMaxX())
                || (object.getMinY() < 0)
                || (getHeight() < object.getMaxY())) {
            throw new IllegalArgumentException("추가하려는 object이 world를 벗어납니다.");
        }

        regionableList.add(object);

    }

    public void remove(Regionable object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        regionableList.remove(object);
    }

    @Override
    public void remove(int index) {
        regionableList.remove(index);
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    public int getCount() {
        return regionableList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Regionable item : regionableList) {
            if (item instanceof Paintable) {
                ((Paintable) item).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < getCount(); i++) {
            Regionable object1 = get(i);

            if (object1 != null) {
                for (int j = i + 1; j < getCount(); j++) {
                    Regionable object2 = get(j);

                    if (object1.intersects(object2)) {
                        Regionable intersection = object1.intersection(object2);

                        g.drawRect(intersection.getMinX(), intersection.getMinY(),
                                intersection.getWidth(), intersection.getHeight());
                    }
                }
            }
        }

        g.setColor(previousColor);
    }
}

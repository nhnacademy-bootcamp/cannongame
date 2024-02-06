package com.nhnacademy.exam060401;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Region> objectList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Region object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        for (Region item : objectList) {
            if (object.intersects(item)) {
                throw new IllegalArgumentException();
            }
        }

        if ((object.getMinX() < 0)
                || (getWidth() < object.getMaxX())
                || (object.getMinY() < 0)
                || (getHeight() < object.getMaxY())) {
            throw new IllegalArgumentException("추가하려는 object이 world를 벗어납니다.");
        }

        objectList.add(object);
    }

    public void remove(Region object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        objectList.remove(object);
    }

    @Override
    public void remove(int index) {
        objectList.remove(index);
    }

    public Region get(int index) {
        return objectList.get(index);
    }

    public int getCount() {
        return objectList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Region object : objectList) {
            if (object instanceof PaintableBall) {
                ((PaintableBall) object).paint(g);
            } else if (object instanceof PaintableBox) {
                ((PaintableBox) object).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < getCount(); i++) {
            Region ball1 = get(i);
            for (int j = i + 1; j < getCount(); j++) {
                Region ball2 = get(j);

                if (ball1.intersects(ball2)) {
                    Region collisionArea = ball1.intersection(ball2);

                    g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                            collisionArea.getWidth(), collisionArea.getHeight());
                }
            }
        }

        g.setColor(previousColor);
    }
}

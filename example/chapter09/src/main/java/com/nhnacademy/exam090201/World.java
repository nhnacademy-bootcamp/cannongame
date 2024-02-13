package com.nhnacademy.exam090201;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.awt.Rectangle;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Regionable> regionableList = new LinkedList<>();
    Logger logger = LogManager.getLogger();
    float scale = 1.0f;
    int baseX = 0;
    int baseY = 0;
    int virtualWidth = 0;
    int virtualHeight = 0;
    int realWidth = 0;
    int realHeight = 0;
    GraphicsTransform transform = new GraphicsTransform();

    public World() {
        super();
        setBackground(Color.GREEN);
    }

    public void setVirtualSize(int width, int height) {
        virtualWidth = width;
        virtualHeight = height;

        transform.setSize(virtualWidth, virtualHeight);
    }

    public void setScale(float scale) {
        this.scale = scale;
        transform.setScale(1 / scale);
    }

    public void setVirtualBase(int x, int y) {
        baseX = x;
        baseY = y;

        transform.setBase(baseX, baseY);
    }

    public int getVirtualWidth() {
        return virtualWidth;
    }

    public int getVirtualHeight() {
        return virtualHeight;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0, 0, getVirtualWidth(), getVirtualHeight());
    }

    public void add(Regionable object) {
        for (Regionable item : regionableList) {
            if (item.intersects(object)) {
                throw new IllegalArgumentException();
            }
        }

        if ((object.getMinX() < 0)
                || (getVirtualWidth() < object.getMaxX())
                || (object.getMinY() < 0)
                || (getVirtualHeight() < object.getMaxY())) {
            throw new IllegalArgumentException("추가하려는 object이 world를 벗어납니다. ["
                    + object.getMaxX() + ", " + object.getMaxY() + ", "
                    + getVirtualWidth() + ", " + getVirtualHeight());
        }

        regionableList.add(object);

    }

    public void addHazard(Regionable object) {
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
        transform.setGraphics(g);

        super.paint(transform);
        for (Regionable item : regionableList) {
            if (item instanceof Paintable) {
                ((Paintable) item).paint(transform);
            }
        }

        Color previousColor = transform.getColor();
        transform.setColor(Color.RED);
        for (int i = 0; i < getCount(); i++) {
            Regionable object1 = get(i);

            if (object1 != null) {
                for (int j = i + 1; j < getCount(); j++) {
                    Regionable object2 = get(j);

                    if (object1.intersects(object2)) {
                        Regionable intersection = object1.intersection(object2);

                        transform.drawRect(intersection.getMinX(), intersection.getMinY(),
                                intersection.getWidth(), intersection.getHeight());
                    }
                }
            }
        }

        g.setColor(previousColor);
    }
}

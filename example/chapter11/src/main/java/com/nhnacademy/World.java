package com.nhnacademy;

import java.util.List;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class World extends JPanel {
    int virtualWidth = 1;
    int virtualHeight = 1;
    int realWidth = 1;
    int realHeight = 1;

    final ExGraphics exGraphics = new ExGraphics();

    final List<Regionable> objectList = new LinkedList<>();

    public void setVirtualSize(int width, int height) {
        if ((width < 1) || (height < 1)) {
            throw new IllegalArgumentException();
        }

        virtualWidth = width;
        virtualHeight = height;

        updateScale();
    }

    public int getVirtualWidth() {
        return virtualWidth;
    }

    public int getVirtualHeight() {
        return virtualHeight;
    }

    public void setRealSize(int width, int height) {
        if ((width < 1) || (height < 1)) {
            throw new IllegalArgumentException();
        }

        realWidth = width;
        realHeight = height;

        setSize(width, height);
        updateScale();
    }

    public int getRealWidth() {
        return realWidth;
    }

    public int getRealHeight() {
        return realHeight;
    }

    void updateScale() {
        if (getRealWidth() > 0 && getRealHeight() > 0) {
            exGraphics.setScaleX((double) virtualWidth / realWidth);
            exGraphics.setScaleY((double) virtualHeight / realHeight);
        }
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);

        exGraphics.setBase(new Point(width / 2, height / 2));
        exGraphics.setViewSize(width, height);
    }

    public void addObject(Regionable object) {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        objectList.add(object);
    }

    public Regionable getObject(int index) {
        return objectList.get(index);
    }

    public int getObjectCount() {
        return objectList.size();
    }

    public void removeObject(int index) {
        objectList.remove(index);
    }

    public void removeObject(Regionable object) {
        objectList.remove(object);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        exGraphics.setGraphics(graphics);

        for (Regionable object : objectList) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(exGraphics);
            }
        }
    }
}

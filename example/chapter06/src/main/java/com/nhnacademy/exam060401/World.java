package com.nhnacademy.exam060401;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Region> regionList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Region newRegion) {
        if (!(newRegion instanceof Region)) {
            throw new IllegalArgumentException();
        }

        for (Region region : regionList) {
            if (region.intersects(newRegion)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newRegion.getMinX() < 0) || (getWidth() < newRegion.getMaxX())
                || (newRegion.getMinY() < 0)
                || (getHeight() < newRegion.getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newRegion이 world를 벗어납니다.");
        }

        regionList.add(newRegion);

    }

    public void remove(Region region) {
        if (region == null) {
            throw new IllegalArgumentException();
        }

        regionList.remove(region);
    }

    @Override
    public void remove(int index) {
        regionList.remove(index);
    }

    public Region get(int index) {
        return regionList.get(index);
    }

    public int getCount() {
        return regionList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Region region : regionList) {
            if (region instanceof PaintableBall) {
                ((PaintableBall) region).paint(g);
            } else if (region instanceof PaintableBox) {
                ((PaintableBox) region).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < getCount(); i++) {
            Region region1 = get(i);

            if (region1 != null) {
                for (int j = i + 1; j < getCount(); j++) {
                    Region region2 = get(j);

                    if (region1.intersects(region2)) {
                        Region collisionArea = region1.intersection(region2);

                        g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                                collisionArea.getWidth(), collisionArea.getHeight());
                    }
                }
            }
        }

        g.setColor(previousColor);
    }
}

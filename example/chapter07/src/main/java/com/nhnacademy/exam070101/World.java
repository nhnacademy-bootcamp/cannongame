package com.nhnacademy.exam070101;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Regionable> regionList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Regionable newRegion) {
        for (Regionable region : regionList) {
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

    public Regionable get(int index) {
        return regionList.get(index);
    }

    public int getCount() {
        return regionList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Regionable region : regionList) {
            if (region instanceof PaintableBall) {
                ((PaintableBall) region).paint(g);
            } else if (region instanceof PaintableBox) {
                ((PaintableBox) region).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < getCount(); i++) {
            Regionable region1 = get(i);

            if (region1 != null) {
                for (int j = i + 1; j < getCount(); j++) {
                    Regionable region2 = get(j);

                    if (region1.intersects(region2)) {
                        Regionable collisionArea = region1.intersection(region2);

                        g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                                collisionArea.getWidth(), collisionArea.getHeight());
                    }
                }
            }
        }

        g.setColor(previousColor);
    }
}

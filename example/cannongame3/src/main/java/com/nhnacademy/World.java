package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class World extends JPanel {
    List<Region> regionList = new LinkedList<>();

    public void add(Region region) {
        regionList.add(region);
    }

    public void remove(Region region) {
        regionList.remove(region);
    }

    public Region getRegion(int index) {
        return regionList.get(index);
    }

    public int getRegionCount() {
        return regionList.size();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for (Region region : regionList) {
            if (region instanceof Paintable) {
                ((Paintable) region).paint(graphics);
            }
        }
    }
}

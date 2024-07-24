package com.nhnacademy;

import java.util.List;
import java.util.LinkedList;
import java.awt.Graphics;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Regionable> regionableList;
    static Logger log = LogManager.getLogger(World.class);

    public World() {
        super();

        regionableList = new LinkedList<>();
        log.debug("World가 생성되었습니다!");
    }

    public void add(Regionable regionable) {
        if (regionable == null) {
            throw new NullPointerException();
        }

        regionableList.add(regionable);
    }

    public void remove(Regionable ball) {
        if (ball == null) {
            throw new NullPointerException();
        }

        regionableList.remove(ball);
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    @Override
    public void remove(int index) {
        regionableList.remove(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable regionable : regionableList) {
            if (regionable instanceof Paintable) {
                ((Paintable) regionable).paint(g);
            } else {
                log.debug("{}은 그릴 수 없습니다.", regionable);
            }
        }
    }
}

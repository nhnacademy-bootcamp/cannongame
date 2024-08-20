package com.nhnacademy;

import javax.print.DocFlavor.READER;

public class MovableWorld extends World {
    public static final int DEFAULT_DT = 250;
    public static final int MAX_MOVE_COUNT = 100;
    int dt = DEFAULT_DT;
    int moveCount;
    int maxMoveCount = MAX_MOVE_COUNT;
    boolean running = false;

    public void reset() {
        moveCount = 0;
    }

    @Override
    public void add(Regionable regionable) {
        if (regionable == null) {
            throw new NullPointerException();
        }

        if (regionable instanceof Bounded) {
            ((Bounded) regionable).setBounds(getBounds());
        }
        regionableList.add(regionable);
        if (running && (regionable instanceof Movable)) {
            new Thread(((Movable) regionable)).start();
        }
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Regionable object = get(i);

            if (object instanceof Movable) {
                ((Movable) object).move();
            }
        }

        repaint();

        moveCount++;
    }

    public void run() {
        running = true;
        for (int i = 0; i < getCount(); i++) {
            Regionable object = get(i);

            if (object instanceof Movable) {
                new Thread((Movable) object).start();
            }
        }

        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            try {
                Thread.sleep(dt);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int count) {
        maxMoveCount = count;
    }

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }
}

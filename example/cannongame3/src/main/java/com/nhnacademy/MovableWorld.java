package com.nhnacademy;

public class MovableWorld extends World {

    int moveCount = 0;
    int maxMoveCount = 0;
    int dt = 1000;

    public void setDT(int dt) {
        this.dt = dt;
    }

    public int getDT() {
        return dt;
    }

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        for (int i = 0; i < getRegionCount(); i++) {
            Region region = getRegion(i);
            if (region instanceof Movable) {
                ((Movable) region).move();
            }
        }

        repaint();
        moveCount++;
    }

    public void run() {
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

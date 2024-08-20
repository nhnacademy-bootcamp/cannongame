package com.nhnacademy;

public class MovableWorld extends World {

    int moveCount;
    int maxMoveCount;

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveVount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Bounded bounded = get(i);

            if (bounded instanceof MovableBall) {
                ((Movable) bounded).move();
            }
        }

        moveCount++;
        repaint();
    }

    public void run() {
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

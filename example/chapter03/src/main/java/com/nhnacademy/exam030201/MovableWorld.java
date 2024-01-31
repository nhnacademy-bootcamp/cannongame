package com.nhnacademy.exam030201;

public class MovableWorld extends World {
    int moveCount = 0;
    int maxMoveCount = 0;

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Ball ball = get(i);

            if (ball instanceof MovableBall) {
                ((MovableBall) ball).move();
            }
        }

        repaint();
    }

    public void run() {
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }
}

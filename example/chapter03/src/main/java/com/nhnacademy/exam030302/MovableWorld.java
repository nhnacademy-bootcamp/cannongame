package com.nhnacademy.exam030302;

public class MovableWorld extends World {
    int moveCount = 0;
    int maxMoveCount = 0;
    int dt = 0;

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
        for (int i = 0; i < getCount(); i++) {
            Ball ball = get(i);

            if (ball instanceof MovableBall) {
                ((MovableBall) ball).move();
            }
        }

        repaint();
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        logger.trace("start");
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            moveCount++;
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        logger.trace("finished : " + (System.currentTimeMillis() - startTime));
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

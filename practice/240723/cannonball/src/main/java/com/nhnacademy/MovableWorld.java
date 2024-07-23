package com.nhnacademy;

public class MovableWorld extends World {
    public static final int DEFAULT_DT = 25;
    public static final int MAX_MOVE_COUNT = 100;
    int dt = DEFAULT_DT;
    int moveCount;
    int maxMoveCount = MAX_MOVE_COUNT;

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        for (int i = 0; i < getBallCount(); i++) {
            Ball ball = getBall(i);

            if (ball instanceof MovableBall) {
                ((MovableBall) ball).move();
            }
        }

        repaint();

        moveCount++;
    }

    public void run() {
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
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

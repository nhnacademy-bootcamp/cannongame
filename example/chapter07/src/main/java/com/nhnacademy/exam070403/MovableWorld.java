package com.nhnacademy.exam070403;

import java.util.LinkedList;
import java.util.List;

public class MovableWorld extends World {
    int moveCount = 0;
    int maxMoveCount = 0;
    int dt = 0;
    List<Motion> effectList = new LinkedList<>();

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
            if (get(i) instanceof Movable) {
                Movable movable = ((Movable) get(i));

                Motion testMotion = new Motion(0, -3);
                movable.getMotion().add(testMotion);

                movable.move();
            }
        }

        repaint();
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long nextMoveTime = startTime + dt;

        logger.trace("start");
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            moveCount++;
            if (dt != 0) {
                try {
                    long currentTime = System.currentTimeMillis();
                    if (nextMoveTime < currentTime) {
                        nextMoveTime += ((currentTime - nextMoveTime) / dt + 1) * dt;
                    } else {
                        Thread.sleep(nextMoveTime - System.currentTimeMillis());
                        nextMoveTime += dt;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                nextMoveTime = System.currentTimeMillis();
            }
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

    public void addEffect(Motion effect) {
        if (effect == null) {
            throw new IllegalArgumentException();
        }

        effectList.add(effect);
    }

    public int getEffectCount() {
        return effectList.size();
    }

    public Motion getEffect(int index) {
        return effectList.get(index);
    }
}

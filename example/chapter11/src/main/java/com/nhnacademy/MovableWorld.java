package com.nhnacademy;

import java.util.List;
import java.util.LinkedList;

public class MovableWorld extends World {
    int moveCount = 0;
    int maxMoveCount = 0;
    int dt = 10;
    List<Vector> effectList = new LinkedList<>();

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    void move(Movable movable) {

        for (int i = 0; i < getEffectCount(); i++) {
            movable.addEffect(getEffect(i));
        }
        movable.move();
    }

    public void addEffect(Vector effect) {
        effectList.add(effect);
    }

    public int getEffectCount() {
        return effectList.size();
    }

    public Vector getEffect(int index) {
        return effectList.get(index);
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long nextMoveTime = startTime + dt;

        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            for (int i = 0; i < getObjectCount(); i++) {
                if (getObject(i) instanceof Movable) {
                    move((Movable) getObject(i));
                }

                repaint();
            }

            moveCount++;
            if (dt != 0) {
                try {
                    long currentTime = System.currentTimeMillis();
                    if (nextMoveTime < currentTime) {
                        nextMoveTime += ((currentTime - nextMoveTime) / dt + 1) * dt;
                    } else {
                        Thread.sleep(nextMoveTime - currentTime);
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
}

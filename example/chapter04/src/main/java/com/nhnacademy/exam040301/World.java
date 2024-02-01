package com.nhnacademy.exam040301;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Ball newBall) {
        if (newBall == null) {
            throw new IllegalArgumentException();
        }

        for (Ball ball : ballList) {
            if (newBall.isCollision(ball)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newBall.getX() - newBall.getRadius() < 0)
                || (getWidth() < newBall.getX() + newBall.getRadius())
                || (newBall.getY() - newBall.getRadius() < 0)
                || (getHeight() < newBall.getY() + newBall.getRadius())) {
            throw new IllegalArgumentException("추가하려는 newBall이 world를 벗어납니다.");
        }

        ballList.add(newBall);
        if (newBall instanceof PaintableBall) {
            logger.trace(String.format("newBall 추가 : %4d, %4d, %4d, %s",
                    ((PaintableBall) newBall).getX(),
                    ((PaintableBall) newBall).getY(),
                    ((PaintableBall) newBall).getRadius(),
                    ((PaintableBall) newBall).getColor().toString()));
        }
    }

    public void remove(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
        }

        ballList.remove(ball);
    }

    @Override
    public void remove(int index) {
        ballList.remove(index);
    }

    public Ball get(int index) {
        return ballList.get(index);
    }

    public int getCount() {
        return ballList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
}

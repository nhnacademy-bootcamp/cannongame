package com.nhnacademy.exam020303;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 볼을 담을 수 있는 공간.
 */
public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    /**
     * World에 볼 추가.
     *
     * @param ball 추가할 볼
     */
    public void add(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
        }

        if ((ball.getX() - ball.getRadius() < 0)
                || (getWidth() < ball.getX() + ball.getRadius())
                || (ball.getY() - ball.getRadius() < 0)
                || (getHeight() < ball.getY() + ball.getRadius())) {
            throw new IllegalArgumentException("추가하려는 ball이 world를 벗어납니다.");
        }

        ballList.add(ball);
        if (ball instanceof PaintableBall) {
            logger.trace(String.format("ball 추가 : %4d, %4d, %4d, %s",
                    ((PaintableBall) ball).getX(),
                    ((PaintableBall) ball).getY(),
                    ((PaintableBall) ball).getRadius(),
                    ((PaintableBall) ball).getColor().toString()));
        }
    }

    /**
     * World에서 볼 제거.
     *
     * @param ball 제거할 볼
     */
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

    public int getCount() {
        return ballList.size();
    }

    @Override
    public void paint(Graphics g) {
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
}

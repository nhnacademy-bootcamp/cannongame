package com.nhnacademy.exam060301;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();
    List<Box> boxList = new LinkedList<>();
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

        for (Box box : boxList) {
            if (newBall.isCollision(box)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newBall.getRegion().getMinX() < 0)
                || (getWidth() < newBall.getRegion().getMaxX())
                || (newBall.getRegion().getMinY() < 0)
                || (getHeight() < newBall.getRegion().getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newBall이 world를 벗어납니다.");
        }

        ballList.add(newBall);
    }

    public void remove(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
        }

        ballList.remove(ball);
    }

    public void removeBall(int index) {
        ballList.remove(index);
    }

    public Ball getBall(int index) {
        return ballList.get(index);
    }

    public int getBallCount() {
        return ballList.size();
    }

    public void add(Box newBox) {
        if (newBox == null) {
            throw new IllegalArgumentException();
        }

        for (Box box : boxList) {
            if (newBox.isCollision(box)) {
                throw new IllegalArgumentException();
            }
        }

        for (Ball ball : ballList) {
            if (newBox.isCollision(ball)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newBox.getRegion().getMinX() < 0)
                || (getWidth() < newBox.getRegion().getMaxX())
                || (newBox.getRegion().getMinY() < 0)
                || (getHeight() < newBox.getRegion().getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newBox이 world를 벗어납니다.");
        }

        boxList.add(newBox);
    }

    public void remove(Box box) {
        if (box == null) {
            throw new IllegalArgumentException();
        }

        boxList.remove(box);
    }

    public void removeBox(int index) {
        boxList.remove(index);
    }

    public Box getBox(int index) {
        return boxList.get(index);
    }

    public int getBoxCount() {
        return boxList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }

        for (Box box : boxList) {
            if (box instanceof PaintableBox) {
                ((PaintableBox) box).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        for (int i = 0; i < getBallCount(); i++) {
            Ball ball1 = getBall(i);
            for (int j = i + 1; j < getBallCount(); j++) {
                Ball ball2 = getBall(j);

                if (ball1.isCollision(ball2)) {
                    Region collisionArea = ball1.getRegion().intersection(ball2.getRegion());

                    g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                            collisionArea.getWidth(), collisionArea.getHeight());
                }
            }

            for (int j = i + 1; j < getBallCount(); j++) {
                Box box = getBox(j);

                if (ball1.isCollision(box)) {
                    Region collisionArea = ball1.getRegion().intersection(box.getRegion());

                    g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                            collisionArea.getWidth(), collisionArea.getHeight());
                }
            }
        }

        for (int i = 0; i < getBoxCount(); i++) {
            Box box1 = getBox(i);
            for (int j = i + 1; j < getBoxCount(); j++) {
                Box box2 = getBox(j);

                if (box1.isCollision(box2)) {
                    Region collisionArea = box1.getRegion().intersection(box2.getRegion());

                    g.drawRect(collisionArea.getMinX(), collisionArea.getMinY(),
                            collisionArea.getWidth(), collisionArea.getHeight());
                }
            }
        }

        g.setColor(previousColor);
    }
}

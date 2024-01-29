package com.nhnacademy.exam020302;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nhnacademy.Ball;
import com.nhnacademy.PaintableBall;

public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
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

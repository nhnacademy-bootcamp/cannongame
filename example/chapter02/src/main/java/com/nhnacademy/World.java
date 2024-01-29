package com.nhnacademy;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();

    public World() {
        super();
    }

    public void add(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
        }

        ballList.add(ball);
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
}

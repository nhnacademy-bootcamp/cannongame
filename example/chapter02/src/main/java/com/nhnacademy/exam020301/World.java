package com.nhnacademy.exam020301;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 * 볼을 담을 수 있는 공간.
 */
public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();

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

        ballList.add(ball);
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
}

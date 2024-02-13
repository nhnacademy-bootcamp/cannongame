package com.nhnacademy.example;

import javax.swing.JFrame;

import com.nhnacademy.MovableBall;
import com.nhnacademy.MovableBox;
import com.nhnacademy.MovableWorld;
import com.nhnacademy.Point;
import com.nhnacademy.PositionalVector;

public class TestMovableWorld {
    static final int WIDTH = 500;
    static final int HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(WIDTH, HEIGHT);

        MovableWorld world = new MovableWorld();
        world.setSize(WIDTH, HEIGHT);
        world.setDT(100);

        MovableBall ball = new MovableBall(new Point(100, 100), 50);
        ball.setDisplacement(new PositionalVector(1, 2));
        world.addObject(ball);
        MovableBox box = new MovableBox(new Point(200, 200), 100, 100);
        box.setDisplacement(new PositionalVector(2, -1));
        world.addObject(box);

        frame.add(world);

        frame.setEnabled(true);
        frame.setVisible(true);

        world.run();
    }

}

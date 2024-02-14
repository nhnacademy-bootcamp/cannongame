package com.nhnacademy.example;

import javax.swing.JFrame;

import com.nhnacademy.DisplacementVector;
import com.nhnacademy.MovableBall;
import com.nhnacademy.MovableWorld;
import com.nhnacademy.PaintableBox;
import com.nhnacademy.Point;

public class TestMovableWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);

        MovableWorld world = new MovableWorld();
        frame.add(world);

        PaintableBox box = new PaintableBox(new Point(100, 100), 100, 100);
        MovableBall ball = new MovableBall(new Point(200, 200), 100);
        ball.setDisplacement(new DisplacementVector(10, 50));

        world.add(box);
        world.add(ball);

        frame.setVisible(true);
        frame.setEnabled(true);

        world.run();
    }
}

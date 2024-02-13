package com.nhnacademy.example;

import javax.swing.JFrame;

import com.nhnacademy.PaintableBall;
import com.nhnacademy.PaintableBox;
import com.nhnacademy.Point;
import com.nhnacademy.World;

public class TestWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);

        World world = new World();
        frame.add(world);

        PaintableBox box = new PaintableBox(new Point(100, 100), 100, 100);
        PaintableBall ball = new PaintableBall(new Point(200, 200), 100);

        world.add(box);
        world.add(ball);

        frame.setVisible(true);
        frame.setEnabled(true);
    }
}

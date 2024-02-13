package com.nhnacademy.example;

import javax.swing.JFrame;

import com.nhnacademy.PaintableBall;
import com.nhnacademy.PaintableBox;
import com.nhnacademy.Point;
import com.nhnacademy.World;

public class TestWorld {
    static final int WIDTH = 500;
    static final int HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(WIDTH, HEIGHT);

        World world = new World();
        world.setSize(WIDTH, HEIGHT);

        world.addObject(new PaintableBall(new Point(100, 100), 50));
        world.addObject(new PaintableBox(new Point(200, 200), 100, 100));
        frame.add(world);
        frame.setEnabled(true);
        frame.setVisible(true);
    }
}

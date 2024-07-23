package com.nhnacademy;

import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);

        BoundedWorld world = new BoundedWorld();
        world.add(new PaintableBall(250, 100, 40, Color.RED));
        MovableBall movableBall = new MovableBall(20, 20, 20, Color.GREEN);
        movableBall.setDX(20);
        movableBall.setDY(10);

        frame.add(world);
        frame.setVisible(true);

        world.add(movableBall);
        world.setDT(100);
        world.setMaxMoveCount(1000);

        world.run();
    }
}
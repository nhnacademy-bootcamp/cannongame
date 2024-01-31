package com.nhnacademy.exam030101;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        world.setSize(400, 300);
        frame.add(world);

        MovableBall ball = new MovableBall(20, 20, 20);
        ball.setDX(10);
        ball.setDY(10);

        world.add(ball);

        frame.setVisible(true);
        frame.setEnabled(true);

        for (int i = 0; i < 1000; i++) {
            ball.move();
        }
    }
}

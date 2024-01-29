package com.nhnacademy.exam020201;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class XFrame extends JFrame {
    PaintableBall ball;

    public void setBall(PaintableBall ball) {
        this.ball = ball;
    }

    public static void main(String[] args) {
        XFrame frame = new XFrame();

        frame.setSize(200, 200);

        frame.setBall(new PaintableBall(100, 100, 50, Color.BLUE));

        frame.setVisible(true);
        frame.setEnabled(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (ball != null) {
            ball.paint(g);
        }
    }
}

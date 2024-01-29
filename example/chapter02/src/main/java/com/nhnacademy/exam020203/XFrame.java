package com.nhnacademy.exam020203;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.nhnacademy.PaintableBall;

public class XFrame extends JFrame {
    PaintableBall ball;

    public void setBall(PaintableBall ball) {
        this.ball = ball;
    }

    public static void main(String[] args) {
        XFrame frame = new XFrame();

        frame.setSize(200, 200);

        PaintableBall ball = new PaintableBall(100, 100, 50);

        if (PaintableBall.DEFAULT_COLOR != ball.getColor()) {
            System.err.println("기본 색 설정이 되지 않습니다.");
            System.exit(1);
        }

        frame.setBall(ball);

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

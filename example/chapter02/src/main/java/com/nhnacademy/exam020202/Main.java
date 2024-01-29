package com.nhnacademy.exam020202;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * 볼을 출력해 보기 위한 테스트 프레임.
 */
public class Main extends JFrame {
    PaintableBall ball;

    public void setBall(PaintableBall ball) {
        this.ball = ball;
    }

    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Main frame = new Main();

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

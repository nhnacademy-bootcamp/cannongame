package com.nhnacademy.exam01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ExamBorderLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);

        frame.setLayout(new BorderLayout());

        JButton[] buttons = new JButton[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("버튼" + (i + 1));
        }

        frame.add(buttons[0], BorderLayout.EAST);
        frame.add(buttons[1], BorderLayout.WEST);
        frame.add(buttons[2], BorderLayout.SOUTH);
        frame.add(buttons[3], BorderLayout.NORTH);
        frame.add(buttons[4], BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setEnabled(true);
        frame.setVisible(true);
    }
}

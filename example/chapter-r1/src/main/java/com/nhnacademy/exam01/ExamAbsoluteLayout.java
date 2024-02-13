package com.nhnacademy.exam01;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExamAbsoluteLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);
        frame.setLayout(null);

        JPanel world = new JPanel();
        world.setBounds(10, 10, 340, 230);
        world.setBackground(Color.WHITE);
        frame.add(world);

        JButton fireButton = new JButton("Fire");
        fireButton.setBounds(20, 250, 50, 30);

        frame.add(fireButton);

        frame.setEnabled(true);
        frame.setVisible(true);
    }
}

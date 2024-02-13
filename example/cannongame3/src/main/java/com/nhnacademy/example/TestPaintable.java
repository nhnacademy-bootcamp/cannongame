package com.nhnacademy.example;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nhnacademy.Paintable;
import com.nhnacademy.PaintableBall;
import com.nhnacademy.PaintableBox;
import com.nhnacademy.Point;

public class TestPaintable extends JPanel {
    List<Paintable> paintableList = new LinkedList<>();

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for (Paintable paintable : paintableList) {
            paintable.paint(graphics);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);

        TestPaintable panel = new TestPaintable();
        frame.add(panel);

        PaintableBox box = new PaintableBox(new Point(100, 100), 100, 100);
        PaintableBall ball = new PaintableBall(new Point(200, 200), 100);

        panel.paintableList.add(box);
        panel.paintableList.add(ball);

        frame.setVisible(true);
        frame.setEnabled(true);
    }
}

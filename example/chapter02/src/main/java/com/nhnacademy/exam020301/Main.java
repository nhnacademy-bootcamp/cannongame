package com.nhnacademy.exam020301;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 볼을 출력해 보기 위한 테스트 프레임.
 */
public class Main {
    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        frame.add(world);

        frame.setVisible(true);
        frame.setEnabled(true);
    }
}

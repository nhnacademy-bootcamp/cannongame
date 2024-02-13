package com.nhnacademy.exam01;

import javax.swing.*;
import javax.swing.event.*;

class ExamSlider {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(300, 100);

        JSlider slider = new JSlider(0, 100, 100);
        // 값 출력용 레이블
        JLabel label = new JLabel();

        // 프레임 크기 설정

        // 슬라이드에 트랙, 틱, 표시
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(작은 눈금 5, 큰 눈금 20)
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        // 슬라이드값이 변경될 때마다 호
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 불투명도 출력
                label.setText("Opacity value is =" + slider.getValue());
                // 불투명도 설정
                frame.setOpacity(slider.getValue() * 0.01f);
            }
        });

        // 패널 구성
        JPanel panel = new JPanel();
        panel.add(slider);
        panel.add(label);

        frame.add(panel);

        // 프레임을 불투명도로 제어하기 위해서는 타이틀바 등의 장식이 없어야 한다.
        frame.setUndecorated(true);

        // 타이틀바가 없어 이동할 수 없음. 생성 시 특정 위치에 생성
        frame.setLocation(500, 300);

        // 화면 출력
        frame.setVisible(true);
    }
}
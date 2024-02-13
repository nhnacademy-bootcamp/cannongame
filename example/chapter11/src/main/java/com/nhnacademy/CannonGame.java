package com.nhnacademy;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

public class CannonGame extends JFrame {
    static final int LABEL_HEIGHT = 20;
    static final int CONTROL_HEIGHT = 50;
    static final int CONTROL_WIDTH = 180;
    static final int GAP = 10;
    static final int MAX_GRAVITY = 10;
    static final int MIN_GRAVITY = 0;
    static final int MAX_WIND = 10;
    static final int MIN_WIND = -10;
    GameWorld world;
    JButton fireButton;
    JButton cleanButton;
    JLabel speedLabel;
    JSlider speedSlider;
    JLabel angleLabel;
    JSlider angleSlider;
    JLabel gravityLabel;
    JSlider gravitySlider;
    JLabel windLabel;
    JSlider windSlider;

    public CannonGame(int width, int height) {
        setSize(width, height);

        setLayout(null);

        world = new GameWorld(width - (CONTROL_WIDTH + 6 * GAP), height,
                (width - CONTROL_WIDTH + 6 * GAP) * 100, height * 100);
        world.setLocation(CONTROL_WIDTH + 4 * GAP, GAP);
        world.setBackground(Color.WHITE);

        world.addHazardBox(0.5, 0.35, 0.2, 0.1, 0.7);
        world.addHazardBox(0.6, 0.25, 0.3, 0.1, 0.8);
        world.addHazardBox(0.5, 0.1, 0.4, 0.2, 0.7);
        world.addTargetBox(new Point(width * 80, height * 5), width * 10, height * 10);

        world.addCannon(0.03, 0.05, 5000, 5000);
        add(world);

        speedLabel = new JLabel("속도");
        speedLabel.setBounds(GAP, GAP, CONTROL_WIDTH, LABEL_HEIGHT);
        add(speedLabel);

        speedSlider = new JSlider(0, 1000, world.getSpeed());
        speedSlider.setBounds(GAP, speedLabel.getY() + speedLabel.getHeight() + GAP, CONTROL_WIDTH, CONTROL_HEIGHT);
        speedSlider.setSize(200, CONTROL_HEIGHT);
        speedSlider.addChangeListener(e -> world.setSpeed(speedSlider.getValue()));

        // 슬라이드에 트랙, 틱, 표시
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(작은 눈금 50, 큰 눈금 200)
        speedSlider.setMajorTickSpacing(200);
        speedSlider.setMinorTickSpacing(50);
        add(speedSlider);

        angleLabel = new JLabel("각도");
        angleLabel.setBounds(GAP, speedSlider.getY() + speedSlider.getHeight() + GAP, CONTROL_WIDTH, LABEL_HEIGHT);
        add(angleLabel);

        angleSlider = new JSlider(0, 90, world.getAngle());
        angleSlider.setBounds(GAP, angleLabel.getY() + angleLabel.getHeight() + GAP, CONTROL_WIDTH, CONTROL_HEIGHT);
        angleSlider.setSize(200, CONTROL_HEIGHT);
        angleSlider.addChangeListener(e -> world.setAngle(angleSlider.getValue()));

        // 슬라이드에 트랙, 틱, 표시
        angleSlider.setPaintTrack(true);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(작은 눈금 5, 큰 눈금 20)
        angleSlider.setMajorTickSpacing(20);
        angleSlider.setMinorTickSpacing(5);
        add(angleSlider);

        gravityLabel = new JLabel("중력");
        gravityLabel.setBounds(GAP, angleSlider.getY() + angleSlider.getHeight() + GAP, CONTROL_WIDTH, LABEL_HEIGHT);
        add(gravityLabel);

        gravitySlider = new JSlider(MIN_GRAVITY, MAX_GRAVITY, world.getGravity());
        gravitySlider.setBounds(GAP, gravityLabel.getY() + gravityLabel.getHeight() + GAP, CONTROL_WIDTH,
                CONTROL_HEIGHT);
        gravitySlider.setSize(200, CONTROL_HEIGHT);

        // 슬라이드에 트랙, 틱, 표시
        gravitySlider.setPaintTrack(true);
        gravitySlider.setPaintTicks(true);
        gravitySlider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(큰 눈금 2)
        gravitySlider.setMajorTickSpacing(2);
        gravitySlider.addChangeListener(e -> world.setGravity(gravitySlider.getValue()));
        add(gravitySlider);

        windLabel = new JLabel("바람");
        windLabel.setBounds(GAP, gravitySlider.getY() + gravitySlider.getHeight() + GAP, CONTROL_WIDTH, LABEL_HEIGHT);
        add(windLabel);

        windSlider = new JSlider(MIN_WIND, MAX_WIND, world.getWind());
        windSlider.setBounds(GAP, windLabel.getY() + windLabel.getHeight() + GAP, CONTROL_WIDTH, CONTROL_HEIGHT);
        windSlider.setSize(200, CONTROL_HEIGHT);

        // 슬라이드에 트랙, 틱, 표시
        windSlider.setPaintTrack(true);
        windSlider.setPaintTicks(true);
        windSlider.setPaintLabels(true);

        // 슬라이드 눈금을 표시(작은 눈금 5, 큰 눈금 20)
        windSlider.setMajorTickSpacing(2);
        windSlider.addChangeListener(e -> world.setWind(windSlider.getValue()));
        add(windSlider);

        fireButton = new JButton("Fire!");
        fireButton.setSize(80, CONTROL_HEIGHT);
        fireButton.addActionListener(e -> world.fire());
        add(fireButton);

        cleanButton = new JButton("Clear!");
        cleanButton.setSize(80, CONTROL_HEIGHT);
        cleanButton.addActionListener(e -> world.clean());
        add(cleanButton);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Insets insets = getInsets();

                int validWidth = getWidth() - insets.left - insets.right;
                int validHeight = getHeight() - insets.top - insets.bottom;

                fireButton.setLocation(5, validHeight - (CONTROL_HEIGHT + 10));
                cleanButton.setLocation(100, validHeight - (CONTROL_HEIGHT + 10));
                world.setSize(validWidth - (CONTROL_WIDTH + 3 * GAP), validHeight - (CONTROL_HEIGHT + 3 * GAP));
            }
        });
    }

    public void run() {
        setEnabled(true);
        setVisible(true);

        world.run();
    }

    static final int WIDTH = 1000;
    static final int HEIGHT = 500;

    public static void main(String[] args) {
        CannonGame game = new CannonGame(WIDTH, HEIGHT);

        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        game.run();
    }
}
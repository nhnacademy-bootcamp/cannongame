package com.nhnacademy.example;

import javax.swing.WindowConstants;

import com.nhnacademy.CannonGame;

public class TestBoundedWorld {
        static final int WIDTH = 1000;
        static final int HEIGHT = 500;

        public static void main(String[] args) {
                CannonGame game = new CannonGame(WIDTH, HEIGHT);

                game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                game.run();
        }

}

package com.nhnacademy.exam020101;

public class Main {
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        int radius = 20;

        Ball ball = new Ball(x, y, radius);

        if ((x != ball.getX()) || (y != ball.getY()) || (radius != ball.getRadius())) {
            System.out.println("Ball 구현이 잘못되었습니다.");
        } else {
            System.out.println("Ball 구현이 완료 되었습니다.");
        }
    }
}

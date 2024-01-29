package com.nhnacademy.exam020101;

/**
 * Ball 클래스 테스트.
 */
public class Main {
    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
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

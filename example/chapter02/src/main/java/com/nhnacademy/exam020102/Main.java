package com.nhnacademy.exam020102;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int loopCount = 100;

        for (int i = 0; i < loopCount; i++) {
            int radius = random.nextInt(Integer.MAX_VALUE);
            int x = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(3) - 1);
            int y = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(3) - 1);

            Ball ball = new Ball(x, y, radius);
            if ((ball.getX() != x) || (ball.getY() != y) || (ball.getRadius() != radius)) {
                System.err.println("Ball class의 구현이 올바르지 않습니다.");
                System.exit(1);
            }
        }

        for (int i = 0; i < loopCount; i++) {
            int illegalCase = random.nextInt(3); // 0: 반지름 음수, 1 : x 위치 오류, 2 : y 위치 오오, 3 : x, y 위치 오류
            int radius = random.nextInt(Integer.MAX_VALUE);
            int x;
            int y;

            if ((illegalCase == 1) || (illegalCase == 3)) {
                x = (Integer.MAX_VALUE - random.nextInt(radius)) * (random.nextInt(1) == 0 ? 1 : -1);
            } else {
                x = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(1) == 0 ? 1 : -1);
            }

            if ((illegalCase == 2) || (illegalCase == 3)) {
                y = (Integer.MAX_VALUE - random.nextInt(radius)) * (random.nextInt(1) == 0 ? 1 : -1);
            } else {
                y = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(1) == 0 ? 1 : -1);
            }

            if (illegalCase == 0) {
                radius = random.nextInt(Integer.MAX_VALUE) * -1;
            }

            boolean exceptionOccurred = false;
            try {
                Ball ball = new Ball(x, y, radius);
                if ((ball.getX() != x) || (ball.getY() != y) || (ball.getRadius() != radius)) {
                    System.err.println("Ball class의 구현이 올바르지 않습니다.");
                    System.exit(1);
                }
            } catch (Exception e) {
                exceptionOccurred = true;
            }

            if (!exceptionOccurred) {
                System.err.println("x : " + x + ", y : " + y + ", radius : " + radius);
                System.err.println("Ball class에서 잘못된 입력에 대한 exception 처리가 되지 않았습니다.");
                System.exit(1);
            }
        }
    }
}

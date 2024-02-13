package com.nhnacademy;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;

public class GameWorld extends BoundedWorld {
    static final int DEFAULT_SPEED = 500;
    static final int DEFAULT_ANGLE = 60;
    static final int DEFAULT_GRAVITY = 5;
    static final int DEFAULT_WIND = 0;

    Point startLocation = new Point(1000, 1000);
    int score = 0;
    double ballCOR = 0.7;
    int ballSize = 1000;
    int speed = DEFAULT_SPEED;
    int angle = DEFAULT_ANGLE;
    Vector gravity = new DisplacementVector(DEFAULT_GRAVITY, -90);
    Vector wind = new DisplacementVector(DEFAULT_WIND, 180);
    Color hazardColor = Color.GRAY;
    List<Regionable> ballList = new LinkedList<>();
    List<Regionable> hazardList = new LinkedList<>();
    List<Regionable> targetList = new LinkedList<>();
    Cannon cannon;
    PaintableBox bottomWall;
    PaintableBox topWall;
    PaintableBox leftWall;
    PaintableBox rightWall;

    public GameWorld(int realWidth, int realHeight, int virtualWidth, int virtualHeight) {
        setRealSize(realWidth, realHeight);
        setVirtualSize(virtualWidth, virtualHeight);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setRealSize(getWidth(), getHeight());
            }
        });

        bottomWall = new PaintableBox(
                new Point(getVirtualWidth() / 2, -getVirtualHeight() / 2),
                getVirtualWidth() * 3, getVirtualHeight());
        topWall = new PaintableBox(
                new Point(getVirtualWidth() / 2, getVirtualHeight() + getVirtualHeight() / 2),
                getVirtualWidth() * 3, getVirtualHeight());
        leftWall = new PaintableBox(
                new Point(-getVirtualWidth() / 2, getVirtualHeight() / 2),
                getVirtualWidth(), getVirtualHeight() * 3);
        rightWall = new PaintableBox(
                new Point(getVirtualWidth() + getVirtualWidth() / 2, getVirtualHeight() / 2),
                getVirtualWidth(), getVirtualHeight() * 3);

        bottomWall.setCOR(0);
        addObject(bottomWall);
        addObject(topWall);
        addObject(leftWall);
        addObject(rightWall);

        addEffect(gravity);
        addEffect(wind);
    }

    public void clean() {
        for (Regionable ball : ballList) {
            removeObject(ball);
        }

        ballList.clear();
    }

    public void setAngle(int angle) {
        this.angle = angle;
        if (cannon != null) {
            cannon.setAngle(angle);
            repaint();
        }
    }

    public int getAngle() {
        return angle;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setGravity(int gravity) {
        this.gravity.set(new DisplacementVector(gravity, -90));
    }

    public int getGravity() {
        return gravity.getMagnitude();
    }

    public void setWind(int wind) {
        this.wind.set(new DisplacementVector(wind, 0));
    }

    public int getWind() {
        return wind.getMagnitude();
    }

    public void fire() {
        FireBall ball = new FireBall(cannon.getFirePit(), ballSize);
        ball.setCOR(ballCOR);
        ball.setDisplacement(new DisplacementVector(speed, angle));
        ball.setAction(o -> {
            if (o instanceof TargetBox) {
                ((TargetBox) o).explode(ball);
            }
            removeCannonBall(ball);
            removeTarget(o);
        });

        addCannonBall(ball);
    }

    public void addCannonBall(FireBall ball) {
        ballList.add(ball);
        addObject(ball);
    }

    public void removeCannonBall(FireBall ball) {
        ballList.remove(ball);
        removeObject(ball);
    }

    public void addCannon(double xRate, double yRate, double widthRate, double heightRate) {
        cannon = new Cannon(new Point((int) (getVirtualWidth() * xRate), (int) (getVirtualHeight() * yRate)),
                (int) (getVirtualWidth() * widthRate), (int) (getVirtualHeight() * heightRate));

        addObject(cannon);
    }

    public void addCannon(double xRate, double yRate, int width, int height) {
        cannon = new Cannon(new Point((int) (getVirtualWidth() * xRate), (int) (getVirtualHeight() * yRate)),
                width, height);

        cannon.setAngle(angle);
        addObject(cannon);
    }

    public void addHazardBox(Point location, int width, int height, double cor) {
        Box box = new PaintableBox(location, width, height, hazardColor);

        box.setCOR(cor);

        hazardList.add(box);
        addObject(box);
    }

    public void addHazardBox(double xRate, double yRate, double widthRate, double heightRate, double cor) {
        addHazardBox(new Point((int) (getVirtualWidth() * xRate), (int) (getVirtualHeight() * yRate)),
                (int) (getVirtualWidth() * widthRate), (int) (getVirtualHeight() * heightRate), cor);
    }

    public void addTarget(Regionable target) {
        targetList.add(target);
        addObject(target);
    }

    public void removeTarget(Regionable target) {
        targetList.remove(target);
        removeObject(target);
    }

    public void addTargetBox(Point location, int width, int height) {
        TargetBox box = new TargetBox(location, width, height);

        box.setAction(e -> {

        });
        addTarget(box);
    }
}

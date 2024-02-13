package com.nhnacademy;

import java.awt.Rectangle;

public class Region {

    final Point location;
    int width;
    int height;

    public Region(Point location, int width, int height) {
        this.location = new Point(location);
        this.width = width;
        this.height = height;
    }

    public Region(Region other) {
        location = new Point(other.getLocation());
        width = other.getWidth();
        height = other.getHeight();
    }

    /**
     * 중심 좌표를 돌려 준다.
     *
     * @return 중심 좌표
     */
    public Point getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMinX() {
        return getLocation().getX() - getWidth() / 2;
    }

    public int getMaxX() {
        return getLocation().getX() + getWidth() / 2;
    }

    public int getMinY() {
        return getLocation().getY() - getHeight() / 2;
    }

    public int getMaxY() {
        return getLocation().getY() + getHeight() / 2;
    }

    /**
     * 위치를 주어진 변화량만큼 이동 시킨다.
     *
     * @param dx X축 변화량
     * @param dy Y축 변화량
     */
    public void translate(int dx, int dy) {
        getLocation().translate(dx, dy);
    }

    /**
     * Region간 충돌 여부를 확인한다.
     *
     * @param other 다른 Region
     * @return 충돌하면 true, 그렇지 않으면 false
     */
    public boolean isCollision(Region other) {
        return (getMaxX() >= other.getMinX()
                || getMinX() <= other.getMaxX()
                || getMaxY() >= other.getMinY()
                || getMaxY() <= other.getMaxY());
    }

    /**
     * 두 region이 중첩될 경우, 중첩된 영역을 얻어 낸다.
     *
     * @param other 다른 region
     * @return 중첩된 region
     */
    public Region intersection(Region other) {
        Rectangle rect1 = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
        Rectangle rect2 = new Rectangle(other.getMinX(), other.getMinY(), other.getWidth(), other.getHeight());

        Rectangle rect3 = rect1.intersection(rect2);

        return new Region(new Point((int) rect3.getCenterX(), (int) rect3.getCenterY()), (int) rect3.getWidth(),
                (int) rect3.getHeight());
    }

    public boolean equals(Object other) {
        return (other instanceof Region)
                && hashCode() == other.hashCode()
                && getLocation().equals(((Region) other).getLocation())
                && getWidth() == ((Region) other).getWidth()
                && getHeight() == ((Region) other).getHeight();
    }

    public int hashCode() {
        return getLocation().hashCode() + getWidth() + getHeight();
    }

    public String toString() { // [(x,y),w,h]
        return "[" + getLocation().toString() + "," + getWidth() + "," + getHeight() + "]";
    }
}

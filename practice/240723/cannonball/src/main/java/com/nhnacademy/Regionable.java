package com.nhnacademy;

public interface Regionable {
    default Location getLocation() {
        return getRegion().getLocation();
    }

    default int getWidth() {
        return getRegion().getWidth();
    }

    default int getHeight() {
        return getRegion().getHeight();
    }

    default int getMinX() {
        return getRegion().getMinX();
    }

    default int getMaxX() {
        return getRegion().getMaxX();
    }

    default int getMinY() {
        return getRegion().getMinY();
    }

    default int getMaxY() {
        return getRegion().getMaxY();
    }

    Region getRegion();

    default boolean intersects(Regionable other) {
        return getRegion().intersects(other.getRegion());
    }

    default Region intersection(Regionable other) {
        return getRegion().intersection(other.getRegion());
    }
}

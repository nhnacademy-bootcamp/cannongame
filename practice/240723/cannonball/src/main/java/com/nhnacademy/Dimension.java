package com.nhnacademy;

public class Dimension {
    int width;
    int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Dimension)
                && (getWidth() == ((Dimension) o).getWidth())
                && (getHeight() == ((Dimension) o).getHeight());
    }
}

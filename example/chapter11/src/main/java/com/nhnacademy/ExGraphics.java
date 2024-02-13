package com.nhnacademy;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class ExGraphics extends Graphics {
    Graphics graphics;
    Region view;
    double scaleX = 1.0;
    double scaleY = 1.0;

    public ExGraphics() {
        view = new Region();
    }

    public ExGraphics(Region view) {
        view = new Region(view);
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setBase(Point location) {
        view.moveTo(location);
    }

    public void setViewSize(int width, int height) {
        view.setWidth(width);
        view.setHeight(height);
    }

    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }

    public double getScaleX() {
        return scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public int transformX(int x) {
        return (int) (x / scaleX) - view.getMinX();
    }

    public int transformY(int y) {
        return view.getHeight() - ((int) (y / scaleY) - view.getMinY());
    }

    public int scaleX(int x) {
        return (int) (x / scaleX);
    }

    public int scaleY(int y) {
        return (int) (y / scaleY);
    }

    @Override
    public void clearRect(int arg0, int arg1, int arg2, int arg3) {
        clearRect(arg0, arg1, arg2, arg3);
    }

    @Override
    public void clipRect(int arg0, int arg1, int arg2, int arg3) {
        clipRect(arg0, arg1, arg2, arg3);
    }

    @Override
    public void copyArea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        copyArea(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public Graphics create() {
        return graphics.create();
    }

    @Override
    public void dispose() {
        graphics.dispose();
    }

    @Override
    public void drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        graphics.drawArc(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
        return graphics.drawImage(arg0, arg1, arg2, arg3);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
        return graphics.drawImage(arg0, arg1, arg2, arg3, arg4);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, ImageObserver arg5) {
        return graphics.drawImage(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, Color arg5, ImageObserver arg6) {
        return graphics.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
            ImageObserver arg9) {
        return graphics.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Override
    public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
            Color arg9, ImageObserver arg10) {
        return graphics.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Override
    public void drawLine(int arg0, int arg1, int arg2, int arg3) {
        graphics.drawLine(arg0, arg1, arg2, arg3);
    }

    @Override
    public void drawRect(int x, int y, int width, int height) {
        graphics.drawRect(transformX(x), transformY(y + height), scaleX(width), scaleY(height));
    }

    @Override
    public void drawOval(int arg0, int arg1, int arg2, int arg3) {
        graphics.drawOval(arg0, arg1, arg2, arg3);
    }

    @Override
    public void drawPolygon(int[] arg0, int[] arg1, int arg2) {
        int[] newArg0 = new int[arg0.length];
        int[] newArg1 = new int[arg1.length];

        for (int i = 0; i < arg0.length; i++) {
            newArg0[i] = transformX(arg0[i]);
        }

        for (int i = 0; i < arg1.length; i++) {
            newArg1[i] = transformY(arg1[i]);
        }

        graphics.drawPolygon(newArg0, newArg1, arg2);
    }

    @Override
    public void drawPolyline(int[] arg0, int[] arg1, int arg2) {
        graphics.drawPolyline(arg0, arg1, arg2);
    }

    @Override
    public void drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        graphics.drawRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public void drawString(String arg0, int arg1, int arg2) {
        graphics.drawString(arg0, arg1, arg2);
    }

    @Override
    public void drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
        graphics.drawString(arg0, arg1, arg2);
    }

    @Override
    public void fillArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        graphics.fillArc(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        graphics.fillOval(transformX(x), transformY(y + height), scaleX(width), scaleY(height));
    }

    @Override
    public void fillPolygon(int[] arg0, int[] arg1, int arg2) {
        int[] newArg0 = new int[arg0.length];
        int[] newArg1 = new int[arg1.length];

        for (int i = 0; i < arg0.length; i++) {
            newArg0[i] = transformX(arg0[i]);
        }

        for (int i = 0; i < arg1.length; i++) {
            newArg1[i] = transformY(arg1[i]);
        }

        graphics.fillPolygon(newArg0, newArg1, arg2);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        graphics.fillRect(transformX(x), transformY(y + height), scaleX(width), scaleY(height));
    }

    @Override
    public void fillRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        graphics.fillRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public Shape getClip() {
        return graphics.getClip();
    }

    @Override
    public Rectangle getClipBounds() {
        return graphics.getClipBounds();
    }

    @Override
    public Color getColor() {
        return graphics.getColor();
    }

    @Override
    public Font getFont() {
        return graphics.getFont();
    }

    @Override
    public FontMetrics getFontMetrics(Font arg0) {
        return graphics.getFontMetrics(arg0);
    }

    @Override
    public void setClip(Shape arg0) {
        graphics.setClip(arg0);
    }

    @Override
    public void setClip(int arg0, int arg1, int arg2, int arg3) {
        graphics.setClip(arg0, arg1, arg2, arg3);
    }

    @Override
    public void setColor(Color arg0) {
        graphics.setColor(arg0);
    }

    @Override
    public void setFont(Font arg0) {
        graphics.setFont(arg0);
    }

    @Override
    public void setPaintMode() {
        graphics.setPaintMode();
    }

    @Override
    public void setXORMode(Color arg0) {
        graphics.setXORMode(arg0);
    }

    @Override
    public void translate(int arg0, int arg1) {
        graphics.translate(arg0, arg1);
    }

}

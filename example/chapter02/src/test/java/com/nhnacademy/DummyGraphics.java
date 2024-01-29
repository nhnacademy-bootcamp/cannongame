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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DummyGraphics extends java.awt.Graphics {
    private Color color;
    List<String> callList = new LinkedList<>();
    Map<String, Integer> callCount = new HashMap<>();
    Map<String, Object> drawOvalParams = new HashMap<>();
    Map<String, Object> fillOvalParams = new HashMap<>();
    Map<String, Object> fillRectParams = new HashMap<>();

    @Override
    public Graphics create() {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void translate(int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'translate'");
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    @Override
    public void setColor(Color c) {
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }

    @Override
    public void setPaintMode() {
        throw new UnsupportedOperationException("Unimplemented method 'setPaintMode'");
    }

    @Override
    public void setXORMode(Color c1) {
        throw new UnsupportedOperationException("Unimplemented method 'setXORMode'");
    }

    @Override
    public Font getFont() {
        throw new UnsupportedOperationException("Unimplemented method 'getFont'");
    }

    @Override
    public void setFont(Font font) {
        throw new UnsupportedOperationException("Unimplemented method 'setFont'");
    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        throw new UnsupportedOperationException("Unimplemented method 'getFontMetrics'");
    }

    @Override
    public Rectangle getClipBounds() {
        throw new UnsupportedOperationException("Unimplemented method 'getClipBounds'");
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Unimplemented method 'clipRect'");
    }

    @Override
    public void setClip(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Unimplemented method 'setClip'");
    }

    @Override
    public Shape getClip() {
        throw new UnsupportedOperationException("Unimplemented method 'getClip'");
    }

    @Override
    public void setClip(Shape clip) {
        throw new UnsupportedOperationException("Unimplemented method 'setClip'");
    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        throw new UnsupportedOperationException("Unimplemented method 'copyArea'");
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        throw new UnsupportedOperationException("Unimplemented method 'drawLine'");
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        callList.add("fillRect");
        try {
            callCount.put("fillRect", callCount.get("fillRect") + 1);
        } catch (NullPointerException ignore) {
            callCount.put("fillRect", 1);
        }
        fillRectParams = new HashMap<>();

        fillRectParams.put("x", x);
        fillRectParams.put("y", y);
        fillRectParams.put("width", width);
        fillRectParams.put("height", height);
        fillRectParams.put("color", color);
    }

    @Override
    public void clearRect(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Unimplemented method 'clearRect'");
    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new UnsupportedOperationException("Unimplemented method 'drawRoundRect'");
    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new UnsupportedOperationException("Unimplemented method 'fillRoundRect'");
    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Unimplemented method 'drawOval'");
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        callList.add("fillOval");
        try {
            callCount.put("fillOval", callCount.get("fillOval") + 1);
        } catch (NullPointerException ignore) {
            callCount.put("fillOval", 1);
        }
        fillOvalParams = new HashMap<>();

        fillOvalParams.put("x", x);
        fillOvalParams.put("y", y);
        fillOvalParams.put("width", width);
        fillOvalParams.put("height", height);
        fillOvalParams.put("color", color);
    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException("Unimplemented method 'drawArc'");
    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new UnsupportedOperationException("Unimplemented method 'fillArc'");
    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Unimplemented method 'drawPolyline'");
    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Unimplemented method 'drawPolygon'");
    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new UnsupportedOperationException("Unimplemented method 'fillPolygon'");
    }

    @Override
    public void drawString(String str, int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'drawString'");
    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        throw new UnsupportedOperationException("Unimplemented method 'drawString'");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
            ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
            Color bgcolor, ImageObserver observer) {
        throw new UnsupportedOperationException("Unimplemented method 'drawImage'");
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

    public Map<String, Object> getFillOvalParams() {
        return fillOvalParams;
    }

    public Map<String, Object> getFillRectParams() {
        return fillRectParams;
    }
}
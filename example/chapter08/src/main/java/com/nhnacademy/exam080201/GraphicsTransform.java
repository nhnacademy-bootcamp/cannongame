package com.nhnacademy.exam080201;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GraphicsTransform extends Graphics {
    Graphics g;
    int baseX = 0;
    int baseY = 0;
    int width = 0;
    int height = 0;
    float scale = 1.0f;

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public void setBase(int x, int y) {
        baseX = x;
        baseY = y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    int scaleWidth(int x) {
        return (int) (x * scale);
    }

    int scaleHeight(int y) {
        return (int) (y * scale);
    }

    int transformX(int x) {
        return scaleWidth(baseX + x);
    }

    int transformY(int y) {
        return scaleHeight(height - (baseY + y));
    }

    @Override
    public Graphics create() {
        return g.create();
    }

    @Override
    public void translate(int x, int y) {
        g.translate(transformX(x), transformY(y));
    }

    @Override
    public Color getColor() {
        return g.getColor();
    }

    @Override
    public void setColor(Color c) {
        g.setColor(c);
    }

    @Override
    public void setPaintMode() {
        g.setPaintMode();
    }

    @Override
    public void setXORMode(Color c1) {
        g.setXORMode(c1);
    }

    @Override
    public Font getFont() {
        return g.getFont();
    }

    @Override
    public void setFont(Font font) {
        g.setFont(font);
    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        return g.getFontMetrics(f);
    }

    @Override
    public Rectangle getClipBounds() {
        return g.getClipBounds();
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {
        g.clipRect(transformX(x), transformY(y), scaleWidth(width), scaleHeight(height));
    }

    @Override
    public void setClip(int x, int y, int width, int height) {
        g.setClip(transformX(x), transformY(y), scaleWidth(width), scaleHeight(height));
    }

    @Override
    public Shape getClip() {
        return g.getClip();
    }

    @Override
    public void setClip(Shape clip) {
        g.setClip(clip);
    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        g.copyArea(x, y, width, height, dx, dy);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawRect(int x, int y, int width, int height) {
        g.drawRect(transformX(x), transformY(y + height), scaleWidth(width), scaleHeight(height));
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        int[] xPoints = { x, x + width, x + width, x };
        int[] yPoints = { y, y, y + height, y + height };
        fillPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public void clearRect(int x, int y, int width, int height) {
        g.clearRect(x, y, width, height);
    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        g.drawRoundRect(transformX(x), transformY(y + height),
                scaleWidth(width), scaleHeight(height), scaleWidth(arcWidth), scaleHeight(arcHeight));
    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
        g.drawOval(transformX(x), transformY(y), width, height);
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        g.fillOval(transformX(x), transformY(y + height), scaleWidth(width), scaleHeight(height));
    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        g.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        g.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        g.drawPolyline(xPoints, yPoints, nPoints);
    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        int[] newXPoints = new int[xPoints.length];
        int[] newYPoints = new int[yPoints.length];

        for (int i = 0; i < xPoints.length; i++) {
            newXPoints[i] = transformX(xPoints[i]);
        }

        for (int i = 0; i < yPoints.length; i++) {
            newYPoints[i] = transformY(yPoints[i]);
        }
        g.drawPolygon(newXPoints, newYPoints, nPoints);
    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        int[] newXPoints = new int[xPoints.length];
        int[] newYPoints = new int[yPoints.length];

        for (int i = 0; i < xPoints.length; i++) {
            newXPoints[i] = transformX(xPoints[i]);
        }

        for (int i = 0; i < yPoints.length; i++) {
            newYPoints[i] = transformY(yPoints[i]);
        }
        g.fillPolygon(newXPoints, newYPoints, nPoints);
    }

    @Override
    public void drawString(String str, int x, int y) {
        g.drawString(str, x, y);
    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        g.drawString(iterator, x, y);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return g.drawImage(img, x, y, observer);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return g.drawImage(img, x, y, width, height, observer);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return g.drawImage(img, x, y, bgcolor, observer);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return g.drawImage(img, x, y, width, height, bgcolor, observer);
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
            ImageObserver observer) {
        return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
            Color bgcolor, ImageObserver observer) {
        return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
    }

    @Override
    public void dispose() {
        g.dispose();
    }
}

package ru.explead.features.logic;

/**
 * Created by develop on 30.12.2016.
 */

public class Circle {

    private float x;
    private float y;

    private float radius;
    private float size;
    private int color;

    public Circle(float x, float y, float size, int color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.radius = size/2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

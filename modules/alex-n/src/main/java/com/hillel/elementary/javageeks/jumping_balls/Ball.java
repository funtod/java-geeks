package com.hillel.elementary.javageeks.jumping_balls;

import java.math.MathContext;

public class Ball {
    private double x;
    private double y;
    private double radius;
    private double deltaX;
    private double deltaY;

    //speed in pixels
    //directions in degrees(-180,180)
    public Ball(int x, int y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        double radians = Math.toRadians(direction);
        double cosinus = Math.cos(radians);
        deltaX = Math.round(Math.cos(Math.toRadians(direction)) * speed * 1000.0)/1000.0;
        deltaY = Math.round(Math.sin(Math.toRadians(direction)) * speed * 1000.0)/1000.0;
    }

    public void move(){
        x += deltaX;
        y += deltaY;
    }

    public void reflectVertical(){
        deltaY = -deltaY;
    }

    public void reflectHorizontal(){
        deltaX = -deltaX;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Ball at (" + x +", " + y + ") of velocity (Δ" + deltaX + ", Δ" + deltaY + ")";
    }
}

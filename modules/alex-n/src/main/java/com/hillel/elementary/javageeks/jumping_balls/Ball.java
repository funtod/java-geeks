package com.hillel.elementary.javageeks.jumping_balls;

public class Ball {
    private double x;
    private double y;
    private double radius;
    private double deltaX;
    private double deltaY;
    public static final double ROUNDING_COEFFICIENT = 1000.0;

    //speed in pixels
    //directions in degrees(-180,180)
    public Ball(int xCoordinate, int yCoordinate, int ballRadius, int ballSpeed, int ballDirection) {
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.radius = ballRadius;
        deltaX = Math.round(Math.cos(Math.toRadians(ballDirection))
                * ballSpeed * ROUNDING_COEFFICIENT) / ROUNDING_COEFFICIENT;
        deltaY = Math.round(Math.sin(Math.toRadians(ballDirection))
                * ballSpeed * ROUNDING_COEFFICIENT) / ROUNDING_COEFFICIENT;
    }

    public final void move() {
        x += deltaX;
        y += deltaY;
    }

    public final void reflectVertical() {
        deltaY = -deltaY;
    }

    public final void reflectHorizontal() {
        deltaX = -deltaX;
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Ball at (" + x + ", " + y + ") of velocity (Δ" + deltaX + ", Δ" + deltaY + ")";
    }
}

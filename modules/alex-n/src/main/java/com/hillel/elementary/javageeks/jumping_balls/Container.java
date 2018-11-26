package com.hillel.elementary.javageeks.jumping_balls;

public class Container {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public final boolean collidesWith(Ball ball) {
        return ball.getX() + ball.getRadius() > x2
                || ball.getY() + ball.getRadius() > y2
                || ball.getX() - ball.getRadius() < x1
                || ball.getY() - ball.getRadius() < y1;
    }

    public final int getX1() {
        return x1;
    }

    public final int getX2() {
        return x2;
    }

    public final int getY1() {
        return y1;
    }

    public final int getY2() {
        return y2;
    }
}

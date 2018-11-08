package com.hillel.elementary.javageeks.jumping_balls;

public class BouncingBalls {

    private Ball[] balls;
    private Container container;

    public BouncingBalls(int x, int y, int width, int height, Ball[] balls){
        this.balls = balls;
        container = new Container(x, y, width, height);
    }

    public BouncingBalls(Container container, Ball[] balls){
        this.balls = balls;
        this.container = container;
    }

    public void nextStep(){
        for (int i = 0; i < balls.length; i++) {
            balls[i].move();
            if (container.collidesWith(balls[i])){
                if (balls[i].getX() + balls[i].getRadius() > container.getX2() ||
                        balls[i].getX() - balls[i].getRadius() < container.getX1()){
                    balls[i].reflectHorizontal();
                }
                if (balls[i].getY() + balls[i].getRadius() > container.getY2() ||
                        balls[i].getY() - balls[i].getRadius() < container.getY1()){
                    balls[i].reflectVertical();
                }
            }
        }
    }

    public Ball[] getBalls() {
        return balls;
    }

    public Container getContainer() {
        return container;
    }
}

package com.hillel.elementary.javageeks.jumping_balls;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container = new Container(0,0, 100, 100);

    @Test
    void shouldReturnFalseIfBallIsNotCollideWithWalls() {
        Ball ball = new Ball(50,50,10,1, 45);
        assertThat(container.collidesWith(ball)).isFalse();
    }

    @Test
    void shouldReturnTrueIfBallCollideWitUpperWall() {
        Ball ball = new Ball(50,10,11,1, 45);
        assertThat(container.collidesWith(ball)).isTrue();
    }

    @Test
    void shouldReturnTrueIfBallCollideWitRightWall() {
        Ball ball = new Ball(90,50,11,1, 45);
        assertThat(container.collidesWith(ball)).isTrue();
    }

    @Test
    void shouldReturnTrueIfBallCollideWitLeftWall() {
        Ball ball = new Ball(10,50,11,1, 45);
        assertThat(container.collidesWith(ball)).isTrue();
    }

    @Test
    void shouldReturnTrueIfBallCollideWitBottomWall() {
        Ball ball = new Ball(50,90,11,1, 45);
        assertThat(container.collidesWith(ball)).isTrue();
    }

}
package com.hillel.elementary.javageeks.jumping_balls;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class BouncingBallsTest {

    Container container = new Container(0, 0, 500, 500);
    Ball[] balls = new Ball[]{new Ball(10,10, 5, 2, 30),
            new Ball(40,40,10, 5, -50)};

    @Test
    void shouldCountNextStepForAllBalls() {
        BouncingBalls bouncingBalls = new BouncingBalls(container, balls);
        bouncingBalls.nextStep();
        assertThat(bouncingBalls.getBalls()[0].getX()).isNotEqualTo(10);
    }
}
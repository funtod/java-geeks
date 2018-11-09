package com.hillel.elementary.javageeks.jumping_balls;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class BallTest {

    Ball ball;

    @Test
    void shouldReturnStringRepresentationOfBall() {
        ball = new Ball(100, 100, 10, 2, 0);
        String expectedOutput = "Ball at (100.0, 100.0) of velocity (Δ2.0, Δ0.0)";
        assertThat(ball.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void shouldChangeBallCoordinates() {
        ball = new Ball(100, 100, 10, 2, 0);
        ball.move();
        assertThat(ball.toString()).isEqualTo("Ball at (102.0, 100.0) of velocity (Δ2.0, Δ0.0)");
    }

    @Test
    void shouldReflectXDeltaValue() {
        ball = new Ball(100, 100, 10, 2, 0);
        ball.reflectHorizontal();
        assertThat(ball.toString()).isEqualTo("Ball at (100.0, 100.0) of velocity (Δ-2.0, Δ0.0)");
    }

    @Test
    void shouldReflectYDeltaValue() {
        ball = new Ball(100, 100, 10, 2, 90);
        ball.reflectVertical();
        assertThat(ball.toString()).isEqualTo("Ball at (100.0, 100.0) of velocity (Δ0.0, Δ-2.0)");
    }
}
package com.hillel.elementary.javageeks.speed_counter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;

class SpeedCounterTest {

    @Test
    void shouldReturnSpeedInMetPerH() {
        int meters = 100000;
        int hours = 1;
        int minute = 25;
        int seconds = 14;
        assertThat(new SpeedCounter(meters,hours,minute,seconds).getSpeedInMetersPerSecond())
                .isCloseTo(19.5542, offset(0.01));
    }

    @Test
    void shouldReturnSpeedInKmPerH() {
        int meters = 100000;
        int hours = 1;
        int minute = 25;
        int seconds = 14;
        assertThat(new SpeedCounter(meters,hours,minute,seconds).getSpeedInKilometersPerHour())
                .isCloseTo(70.39512, offset(0.01));
    }

    @Test
    void shouldReturnSpeedInMilesPerH() {
        int meters = 100000;
        int hours = 1;
        int minute = 25;
        int seconds = 14;
        assertThat(new SpeedCounter(meters,hours,minute,seconds).getSpeedInMilesPerHour())
                .isCloseTo(43.7414, offset(0.01));
    }
}

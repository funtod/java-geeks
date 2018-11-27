package com.hillel.elementary.javageeks.speed_counter;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SpeedCounterTest {

    @Test
    void shouldReturnSpeed() {
        int meters = 100000;
        int hours = 1;
        int minute = 25;
        int seconds = 14;

        assertThat(new DecimalFormat("#.####").format(SpeedCounter.countSpeedInMetersPerSecond(meters,hours,minute,seconds))).isEqualTo("19.5542");
    }
}
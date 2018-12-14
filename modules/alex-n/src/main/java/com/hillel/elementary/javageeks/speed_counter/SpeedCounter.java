package com.hillel.elementary.javageeks.speed_counter;

public final class SpeedCounter {

    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final double MET_PER_SEC_TO_KM_PER_H_COEFFICIENT = 3.6;
    private static final double MET_PER_SEC_TO_MIL_PER_H_COEFFICIENT = 2.237;

    private int distance;
    private int hours;
    private int minutes;
    private int seconds;

    SpeedCounter(int distance, int hours, int minutes, int seconds) {
        this.distance = distance;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    double getSpeedInMetersPerSecond() {
        return (double) distance / (hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds);
    }

    double getSpeedInKilometersPerHour() {
        return getSpeedInMetersPerSecond() * MET_PER_SEC_TO_KM_PER_H_COEFFICIENT;
    }

    double getSpeedInMilesPerHour() {
        return getSpeedInMetersPerSecond() * MET_PER_SEC_TO_MIL_PER_H_COEFFICIENT;
    }
}

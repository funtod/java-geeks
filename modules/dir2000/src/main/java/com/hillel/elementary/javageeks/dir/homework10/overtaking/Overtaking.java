package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import java.util.Objects;

public class Overtaking {
    private final double time;
    private final int carOneId;
    private final int carTwoId;

    public Overtaking(double argTime, int argCarOneId, int argCarTwoId) {
        this.time = argTime;
        this.carOneId = argCarOneId;
        this.carTwoId = argCarTwoId;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Overtaking that = (Overtaking) o;
        return Double.compare(that.time, time) == 0
                && carOneId == that.carOneId
                && carTwoId == that.carTwoId;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(time, carOneId, carTwoId);
    }

    public final double getTime() {
        return time;
    }

    @Override
    public final String toString() {
        return "Overtaking{"
                + "time=" + time
                + ", carOneId=" + carOneId
                + ", carTwoId=" + carTwoId
                + '}';
    }
}

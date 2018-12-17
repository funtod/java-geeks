
package com.hillel.elementary.javageeks.dir.homework10.overtaking;

public class Car {
    private final int id;
    private final double initialPosition;
    private final int speed;

    public Car(int argId, double argInitialPosition, int argSpeed) {
        this.id = argId;
        this.initialPosition = argInitialPosition;
        this.speed = argSpeed;
    }

    @Override
    public final String toString() {
        return "Car{"
                + id
                + '}';
    }

    public final int getId() {
        return id;
    }

    public final double getInitialPosition() {
        return initialPosition;
    }

    public final int getSpeed() {
        return speed;
    }

    public final double getPosition(double time) {
        return initialPosition + speed * time;
    }
}

package com.hillel.elementary.javageeks.dir.homework10.overtaking;

public class Overtaking {
  private double time;
  private Car carOne;
  private Car carTwo;

  @Override
  public String toString() {
    return "Overtaking{" +
            "time=" + time +
            ", carOne=" + carOne +
            ", carTwo=" + carTwo +
            '}';
  }

  public Overtaking(double time, Car carOne, Car carTwo) {
    this.time = time;
    this.carOne = carOne;
    this.carTwo = carTwo;
  }
}

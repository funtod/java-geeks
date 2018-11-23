package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import java.util.ArrayList;

public class Race {
  private Track track;
  private Car[] cars;

  public Race(Track track, Car[] cars) {
    this.track = track;
    this.cars = cars;
  }

  public Iterable getOvertakings(){
    ArrayList<Overtaking> list = new ArrayList<>();
    for (int i = 0; i < cars.length - 1; i++) {
      for (int j = i + 1; j < cars.length; j++) {
        Car carOne = cars[i];
        Car carTwo = cars[j];

        double speedOfOne = carOne.getSpeed();
        double speedOfTwo = carTwo.getSpeed();
        if (speedOfOne == speedOfTwo) {
          continue;
        }

        double overtakingTime = (carOne.getInitialPosition() - carTwo.getInitialPosition())
                / (speedOfOne - speedOfTwo);
        if (overtakingTime < 0) {
          continue;
        }

        double position = carOne.getPosition(overtakingTime);
        if (position > track.getLenght()) {
          continue;
        }

        Overtaking overtaking = new Overtaking(overtakingTime, carOne, carTwo);
        list.add(overtaking);
      }
    }
    return list;
  }
}

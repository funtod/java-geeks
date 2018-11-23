package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

  @Test
  void getOvertakingsTest() {
    //given
    final int trackLenght = 500;
    final int carsCount = 20;
    final int maxSpeed = 250;
    Random random = new Random();

    Track track = new Track(trackLenght);
    Car[] cars = new Car[carsCount];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(random.nextDouble() * trackLenght, random.nextInt(maxSpeed));
    }
    Race race = new Race(track, cars);

    //when
    Iterable result = race.getOvertakings();

    //then
    Iterator iterator = result.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }


}
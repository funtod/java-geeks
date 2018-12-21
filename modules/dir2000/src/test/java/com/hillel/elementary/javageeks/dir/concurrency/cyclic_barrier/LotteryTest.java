package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

  @Test
  void play() {
    //given
    int yearOfDrawing = 2018;
    int counts = 4;
    int possibleCounts = 9;
    String[] playersNames = new String[] {"Jack", "Jill", "John"};

    //when
    Lottery lottery = new Lottery(yearOfDrawing, counts, possibleCounts, playersNames);
    lottery.play();

    //then
    String expectedWinnersName = "Jill";
    String winnersName = lottery.getWinnersName();
    assertEquals(expectedWinnersName, winnersName);
  }
}
package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

import java.util.Arrays;
import java.util.Random;

public class Bet {
  private int[] numbers;

  public Bet(Random random, int counts, int possibleCounts) {
    numbers = new int[counts];
    for (int i = 0; i < counts; i++) {
      numbers[i] = random.nextInt(possibleCounts) + 1;
    }
  }

  @Override
  public boolean equals(Object argO) {
    if (this == argO) {
      return true;
    }
    if (argO == null || getClass() != argO.getClass()) {
      return false;
    }
    Bet bet = (Bet) argO;
    return Arrays.equals(numbers, bet.numbers);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(numbers);
  }
}

package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

final class Player implements Runnable {
  private final String name;
  private final CyclicBarrier barrier;
  private final Random random;
  private final int counts;
  private final int possibleCounts;
  private Bet bet;

  Player(String argName, CyclicBarrier argBarrier, int argCounts, int argPossibleCounts) {
    name = argName;
    barrier = argBarrier;
    random = new Random(argName.hashCode());
    counts = argCounts;
    possibleCounts = argPossibleCounts;
  }

  String getName() {
    return name;
  }

  Bet getBet() {
    return bet;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        bet = new Bet(random, counts, possibleCounts);
        barrier.await();
      }
    } catch (InterruptedException e) {
      // A legitimate way to exit
    } catch (BrokenBarrierException e) {
      // This one we want to know about
      throw new RuntimeException(e);
    }
  }
}

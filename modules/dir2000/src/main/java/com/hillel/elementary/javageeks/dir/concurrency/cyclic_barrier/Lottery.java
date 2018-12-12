package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Lottery {
  private final int yearOfDrawing;
  private final int counts;
  private final int possibleCounts;
  private final CyclicBarrier barrier;
  private final Random random;
  private final Player[] players;
  private ExecutorService exec;
  private String winnersName;

  public String getWinnersName() {
    return winnersName;
  }

  public Lottery(int argYearOfDrawing, int argCounts, int argPossibleCounts, String[] argPlayersNames) {
    yearOfDrawing = argYearOfDrawing;
    counts = argCounts;
    possibleCounts = argPossibleCounts;

    barrier = new CyclicBarrier(argPlayersNames.length, new EvaluationOfTheResults());
    random = new Random(yearOfDrawing);
    exec = Executors.newCachedThreadPool();

    players = new Player[argPlayersNames.length];
    int index = 0;
    for (String name : argPlayersNames) {
      players[index++] = new Player(name, barrier, counts, possibleCounts);
    }
  }

  public void play() {
    for (Player player : players) {
      exec.execute(player);
    }

    while (winnersName == null) {
      int sleepingTime = 500;
      try {
        Thread.sleep(sleepingTime);
      } catch (InterruptedException argE) {
        argE.printStackTrace();
      }
    }
  }

  private class EvaluationOfTheResults implements Runnable {
    @Override
    public void run() {
      Bet winningBet = new Bet(random, counts, possibleCounts);
      for (Player player : players) {
        Bet playersBet = player.getBet();
        if (winningBet.equals(playersBet)) {
          winnersName = player.getName();
          exec.shutdownNow();
          break;
        }
      }
    }
  }
}

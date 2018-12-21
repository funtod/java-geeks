/*JG-106
* Реализовать CyclicBarrier
* Он приостанавливает все потоки, которые вызывают его метод await до
  тех пор, пока их не наберётся нужное количество, указанное в конструкторе.
  Также в конструкторе можно передать объект, реализующий знакомый нам интерфейс Runnable,
  который будет выполнен по достижению размера очереди потоков определённого количества*/

package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Lottery {
  private final int counts;
  private final int possibleCounts;
  private final Random random;
  private final ExecutorService exec;
  private final Player[] players;
  private volatile String winnersName;

  public String getWinnersName() {
    return winnersName;
  }

  public Lottery(int argYearOfDrawing, int argCounts, int argPossibleCounts, String[] argPlayersNames) {
    if (argCounts <= 0 || argPossibleCounts <= 0 || argCounts > argPossibleCounts
      || argPlayersNames == null || argPlayersNames.length == 0) {
        throw new IllegalArgumentException("Wrong counts!");
    }
    counts = argCounts;
    possibleCounts = argPossibleCounts;

    MyCyclicBarrier barrier = new MyCyclicBarrier(argPlayersNames.length, new EvaluationOfTheResults());
    random = new Random(argYearOfDrawing);
    exec = Executors.newFixedThreadPool(argPlayersNames.length);

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
      final int sleepingTime = 100;
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

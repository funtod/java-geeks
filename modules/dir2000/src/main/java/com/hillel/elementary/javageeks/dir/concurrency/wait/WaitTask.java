package com.hillel.elementary.javageeks.dir.concurrency.wait;

/**
 * Как сделать так, чтобы потоки вызывались по очереди?
 * <p>
 * Часто необходимо упорядочить потоки, т.к. результат одного потока
 * понадобится другому, и нужно дождаться, когда первый поток сделает свою работу.
 * <p>
 * Задача: добавьте еще один поток, который будет выводить в лог сообщения о
 * значениях счетчика, кратных 10, например 10, 20, 30...
 * При этом такие сообщения должны выводиться после того, как все потоки преодолели
 * кратность 10, но до того, как какой-либо поток двинулся дальше.
 */

public class WaitTask {
  private final Object monitor = new Object();
  private volatile int t1Counter = 0, t2Counter = 0;
  private volatile int barrier;

  class TestThread implements Runnable {
    private final String threadName;
    private final int n;

    TestThread(String threadName, int n) {
      this.threadName = threadName;
      this.n = n;
    }

    @Override
    public void run() {
      final int iterations = 100;
      final int multiplicity = 10;
      for (int i = 0; i < iterations; i++) {
        System.out.println(threadName + ":" + i);
        synchronized (monitor) {
          try {
            monitor.notifyAll();
            Thread.yield();

            if (n == 1) {
              t1Counter = i;
              if (t1Counter != 0 && t1Counter % multiplicity == 0) {
                barrier++;
                while (barrier != 0) {
                  monitor.wait();
                }
              }
            }
            if (n == 2) {
              t2Counter = i;
              if (t2Counter != 0 && t2Counter % multiplicity == 0) {
                barrier++;
                while (barrier != 0) {
                  monitor.wait();
                }
              }
            }

            if (n == 1) {
              while (i > t2Counter) {
                System.out.println("t1 is ahead with i=" + i + ", wait for t2Counter=" + t2Counter);
                monitor.wait();
              }
            }
            if (n == 2) {
              while (i > t1Counter) {
                System.out.println("t2 is ahead with i=" + i + ", wait for t1Counter=" + t1Counter);
                monitor.wait();
              }
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        Thread.yield();
      }
      System.out.println("Exiting " + threadName);
    }
  }

  class Observer implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          synchronized (monitor) {
            while (barrier != 2) {
              monitor.wait();
            }
            System.out.println("Observer sees: " + t1Counter);
            barrier = 0;
            monitor.notifyAll();
            Thread.yield();
          }
        } catch (InterruptedException argE) {
          System.out.println("Exiting observer");
          return;
        }
      }
    }
  }

}

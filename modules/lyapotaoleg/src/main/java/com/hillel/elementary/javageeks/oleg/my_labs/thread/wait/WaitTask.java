package com.hillel.elementary.javageeks.oleg.my_labs.thread.wait;

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
    private int t1Counter = 0, t2Counter = 0;

    class TestThread implements Runnable {
        String threadName;
        int n;

        public TestThread(String threadName, int n) {
            this.threadName = threadName;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(threadName + ":" + i);
                synchronized (monitor) {
                    if (n == 1) {
                        t1Counter = i;
                    }
                    if (n == 2) {
                        t2Counter = i;
                    }
                    monitor.notify();
                    Thread.yield();
                    try {
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

}

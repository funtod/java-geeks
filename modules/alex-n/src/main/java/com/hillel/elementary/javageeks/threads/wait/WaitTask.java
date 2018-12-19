package com.hillel.elementary.javageeks.threads.wait;

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
    private boolean t1ReadyToPrint = false;
    private boolean t2ReadyToPrint = false;

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
                synchronized (monitor) {
                    if (n == 1) {
                        System.out.println(threadName + ":" + i);
                        t1Counter = i;
                        if (t1Counter % 10 == 0) {
                            t1ReadyToPrint = true;
                        }
                    }
                    if (n == 2) {
                        System.out.println(threadName + ":" + i);
                        t2Counter = i;
                        if (t2Counter % 10 == 0) {
                            t2ReadyToPrint = true;
                        }
                    }
                    monitor.notifyAll();
                    Thread.yield();
                    try {
                        if (n == 1) {
                            while (i > t2Counter) {
                                System.out.println("t1 is ahead with i=" + i + ", wait for t2Counter=" + t2Counter);
                                monitor.wait();
                            }
                            while (t1ReadyToPrint) {
                                System.out.println("t1 is waiting for t3 print");
                                monitor.wait();
                            }
                        }
                        if (n == 2) {
                            while (i > t1Counter) {
                                System.out.println("t2 is ahead with i=" + i + ", wait for t1Counter=" + t1Counter);
                                monitor.wait();
                            }
                            while (t2ReadyToPrint) {
                                System.out.println("t2 is waiting for t3 print");
                                monitor.wait();
                            }
                        }
                        if (n == 3) {
                            while (!t1ReadyToPrint || !t2ReadyToPrint){
                                monitor.wait();
                            }
                            System.out.println("Hi, this is t3 :) Just want to say that threads get to:" + t1Counter);
                            t1ReadyToPrint = false;
                            t2ReadyToPrint = false;
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
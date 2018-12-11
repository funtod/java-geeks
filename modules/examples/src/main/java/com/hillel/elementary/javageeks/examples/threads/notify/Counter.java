package com.hillel.elementary.javageeks.examples.threads.notify;

public class Counter implements Runnable {
    private static long time = 0;
    private final static Object LOCK = new Object();
    private int flag;

    public Counter(int flag) {
        this.flag = flag;
    }

    public void run() {
        try {
            for (; ; ) {
                if (flag == 0) {
                    setTime();
                }
                write();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    private synchronized static void setTime() {
        time++;
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }

    private synchronized void write() throws InterruptedException {
        if (flag == 0) {
            System.out.println(time);
        }

        if (flag == 1) {
            long time2 = time;
            while (time - time2 < 15) {
                synchronized (LOCK) {
                    LOCK.wait();
                }
            }
            System.out.println("Hello1");
        }

        if (flag == 2) {
            long time2 = time;
            while (time - time2 < 7) {
                synchronized (LOCK) {
                    LOCK.wait();
                }
            }
            System.out.println("Hello2");
        }
    }

    public static void main(String[] args) {
        Runnable counterOne = new Counter(0);
        Runnable counterTwo = new Counter(1);
        Runnable counterThree = new Counter(2);

        new Thread(counterOne).start();
        new Thread(counterTwo).start();
        new Thread(counterThree).start();
    }
}
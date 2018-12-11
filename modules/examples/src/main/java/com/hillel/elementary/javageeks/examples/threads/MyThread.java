package com.hillel.elementary.javageeks.examples.threads;

public class MyThread implements Runnable {
    private static long time = 0;
    private final static Object obj = new Object();
    private int flag;

    public MyThread(int flag) {
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

    synchronized public static void setTime() {
        time++;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    synchronized public void write() throws InterruptedException {
        if (flag == 0) {
            System.out.println(time);
        }

        if (flag == 1) {
            long time2 = time;
            while (time - time2 < 15) {
                synchronized (obj) {
                    obj.wait();
                }
            }
            System.out.println("Hello1");
        }

        if (flag == 2) {
            long time2 = time;
            while (time - time2 < 7) {
                synchronized (obj) {
                    obj.wait();
                }
            }
            System.out.println("Hello2");
        }
    }

    public static void main(String[] args) {
        Runnable th1 = new MyThread(0);
        Runnable th2 = new MyThread(1);
        Runnable th3 = new MyThread(2);

        new Thread(th1).start();
        new Thread(th2).start();
        new Thread(th3).start();
    }
}
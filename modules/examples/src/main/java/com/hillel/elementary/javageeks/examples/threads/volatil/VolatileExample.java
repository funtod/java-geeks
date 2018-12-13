package com.hillel.elementary.javageeks.examples.threads.volatil;

public class VolatileExample {

    private volatile static int VAL = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int localVal = VAL;
                while (localVal < 5) {
                    if (localVal != VAL) {
                        System.out.println("Changing localVal to " + VAL);
                        localVal = VAL;
                    }
                }

                System.out.println("Val has changed: " + VAL);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int localVal = VAL;
                while (VAL < 5) {
                    System.out.println("Incrementing MY_INT to " + (localVal + 1));
                    VAL = ++localVal;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}

package com.hillel.elementary.javageeks.examples.threads.stop;

public class Interruption extends Thread {
    private static int howOften;
    private int cyclesCount;
    private Thread otherThread;
    private String word;

    public Interruption(String whatToSay) {
        word = whatToSay;
    }

    void setThread(Thread thread) {
        otherThread = thread;
    }

    public void run() {
        while (!interrupted() && cyclesCount++ <= howOften) {
            otherThread.interrupt();
            System.out.println(word);
        }

        System.out.println("Exiting " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        howOften = 2;
        Thread cur = currentThread();
        cur.setPriority(Thread.MAX_PRIORITY);

        Interruption thread1 = new Interruption("Did");
        Interruption thread2 = new Interruption("Did Not");

        thread1.setThread(thread2);
        thread2.setThread(thread1);

        thread1.start();
        thread2.start();
    }
}

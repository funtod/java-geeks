package com.hillel.elementary.javageeks.oleg.my_labs.thread.wait;

public class Starter {

    public static void main(String[] args) {
        WaitTask waitTask = new WaitTask();

        Thread t1 = new Thread(waitTask.new TestThread ("t1", 1));
        Thread t2 = new Thread(waitTask.new TestThread ("t2", 2));

        System.out.println("Starting threads");
        t1.start();
        t2.start();

        System.out.println("Waiting for threads");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

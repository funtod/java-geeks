package com.hillel.elementary.javageeks.examples.threads.tasks.termination;

public class Runner {


    public static void main(String[] args) {
        WaitTerminateTask terminateTask = new WaitTerminateTask();

        WaitTerminateTask.TestThread testThread1 = terminateTask.new TestThread("t1");
        Thread t1 = new Thread(testThread1);
        WaitTerminateTask.TestThread testThread2 = terminateTask.new TestThread("t2");
        Thread t2 = new Thread(testThread2);

        System.out.println("Starting threads...");
        t1.start();
        t2.start();

        Thread terminator = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testThread2.shouldTerminate = true;
            }
        });
        terminator.start();

        System.out.println("Waiting threads to join...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

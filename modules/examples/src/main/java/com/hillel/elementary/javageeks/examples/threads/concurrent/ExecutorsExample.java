package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }


    static class WorkerThread implements Runnable {

        private String command;

        public WorkerThread(String s) {
            this.command = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End.");
        }

        private void processCommand() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //почему это плохо? shutdownNow()
                e.printStackTrace();
            }
        }
    }
}

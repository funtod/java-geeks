package com.hillel.elementary.javageeks.examples.threads.tasks.wait_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WaitTaskWithBarrier {
    private CyclicBarrier barrier = new CyclicBarrier(2, new BarrierRunnable("barrier"));

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
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        }
    }

}

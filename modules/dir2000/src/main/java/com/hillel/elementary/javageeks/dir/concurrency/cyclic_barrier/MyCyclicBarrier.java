package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

public class MyCyclicBarrier {
    private int capacity;
    private int counter;
    private final Object gate;
    private final Object barrier;
    private Runnable task;

    public MyCyclicBarrier(int argCapacity, Runnable task) {
        this(argCapacity);
        this.task = task;
    }

    public MyCyclicBarrier(int argCapacity) {
        if (argCapacity < 1) {
            throw new IllegalArgumentException("Wrong capacity");
        }
        capacity = argCapacity;
        counter = argCapacity;
        gate = new Object();
        barrier = new Object();
    }

    public void await() throws InterruptedException {
        synchronized (gate) {
            if (counter == 1) {
                if (task != null) {
                    Thread thread = new Thread(task);
                    thread.start();
                    while (thread.isAlive()) {
                        int sleepTime = 1;
                        Thread.sleep(sleepTime);
                    }
                }
                synchronized (barrier) {
                    barrier.notifyAll();
                }
                Thread.yield();
                counter = capacity;
                return;
            } else {
                counter--;
            }
        }
        synchronized (barrier) {
            barrier.wait();
        }
    }
}

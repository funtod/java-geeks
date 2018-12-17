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
                    thread.join();
                }
                synchronized (barrier) {
                    while (counter != capacity) {
                        //until all tasks go through the barrier (the counter is restored)
                        barrier.notifyAll();
                        final int timeout = 100;
                        barrier.wait(timeout);
                    }
                }
                return;
            } else {
                counter--;
            }
        }
        synchronized (barrier) {
            barrier.wait();
            counter++;
            barrier.notifyAll();
        }
    }
}

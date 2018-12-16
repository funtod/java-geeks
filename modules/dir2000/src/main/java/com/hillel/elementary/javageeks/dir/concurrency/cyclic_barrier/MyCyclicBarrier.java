package com.hillel.elementary.javageeks.dir.concurrency.cyclic_barrier;

public class MyCyclicBarrier {
    private int pointer;
    private Object[] monitors;
    private Object mainMonitor;
    private Object placeHolder;
    private Runnable task;

    public MyCyclicBarrier(int argCapacity, Runnable task) {
        this(argCapacity);
        this.task = task;
    }

    public MyCyclicBarrier(int argCapacity) {
        if (argCapacity < 1) {
            throw new IllegalArgumentException("Wrong capacity");
        }
        pointer = argCapacity - 1;
        monitors = new Object[argCapacity];
        for (int i = 0; i < argCapacity; i++) {
            monitors[i] = new Object();
        }
        mainMonitor = new Object();
        placeHolder = new Object();
    }

    public void await() {
        Object currentMonitor = placeHolder;
        synchronized (mainMonitor) {
            if (pointer == 0) {
                if (task != null) {
                    Thread thread = new Thread(task);
                    thread.start();
                    while (thread.isAlive()) {
                        int sleepTime = 100;
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (Object monitor: monitors) {
                    monitor.notify();
                }
                pointer = monitors.length - 1;
            }
            currentMonitor = monitors[pointer];
        }
        synchronized (currentMonitor) {
            try {
                currentMonitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

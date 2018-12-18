package com.hillel.elementary.javageeks.examples.threads.tasks.wait_barrier;

class BarrierRunnable implements Runnable {
    private String threadName;
    private int count = 0;

    public BarrierRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if (count % 10 == 0 && count > 0)
            System.out.println(threadName + ":" + count);
        count++;
    }
}

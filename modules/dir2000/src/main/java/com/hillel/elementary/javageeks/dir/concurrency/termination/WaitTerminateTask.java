package com.hillel.elementary.javageeks.dir.concurrency.termination;

/**
 * Как остановить поток?
 * <p>
 * Для того, чтобы прервать поток, мы можем использовать флаг
 * shouldTerminate, который должен проверяться в цикле внутри run().
 * Если флаг становится true, мы просто выходим из цикла.
 * <p>
 * Однако, тут могут быть проблемы, если от нашего потока зависят другие потоки.
 * В настоящий момент поток t2 прерывается, и программа подвисает,
 * т.к. поток t1 ждет второй поток и не может дождаться.
 * Какие есть решения проблемы?
 */
public class WaitTerminateTask {
    private final Object monitor = new Object();
    private int runningThreadNumber = 1;

    class TestThread implements Runnable {
        String threadName;
        boolean shouldTerminate;

        public TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(threadName + ":" + i);
                synchronized (monitor) {
                    System.out.println(threadName + ":" + i + " is into synch");
                    try {
                        boolean waited = false;
                        System.out.println(threadName + ".equals(t" + runningThreadNumber + ")");
                        while (!threadName.equals("t" + runningThreadNumber)) {
                            waited = true;
                            System.out.println("wait for thread " + "t" + runningThreadNumber);
                            monitor.wait();
                        }
                        if (waited) {
                            System.out.println(threadName + " awakened");
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted " + threadName);
                    }
                    runningThreadNumber++;
                    System.out.println("runningThreadNumber is now: " + runningThreadNumber);
                    if (runningThreadNumber > 2) runningThreadNumber = 1;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted " + threadName);
                    }
                    monitor.notifyAll();
                    if (shouldTerminate) {
                        System.out.println("Terminating " + threadName);
                        return;
                    }
                    System.out.println(threadName + ":" + i + " is out of synch");
                }
            }
        }
    }

}
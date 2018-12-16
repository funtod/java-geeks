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
    private boolean independentMode;

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
                    try {
                        while (!threadName.equals("t" + runningThreadNumber) && !independentMode) {
                            System.out.println("wait for thread " + "t" + runningThreadNumber);
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted " + threadName);
                    }
                    runningThreadNumber++;
                    if (runningThreadNumber > 2) runningThreadNumber = 1;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted " + threadName);
                    }
                    monitor.notifyAll();
                    if (shouldTerminate) {
                        independentMode = true;
                        System.out.println("Terminating " + threadName);
                        return;
                    }
                }
            }
        }
    }

}
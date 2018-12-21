package com.hillel.elementary.javageeks.examples.threads.concurrent.atomics;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumWithoutAtomic {
    public static void main(String[] args) throws InterruptedException {
        Sum sum = new Sum();
        Summer summer1 = new Summer(new long[]{1, 2, 3, 4, 5}, sum);
        Summer summer2 = new Summer(new long[]{-1, -2, -3, -4, -5}, sum);
        List<Summer> summers = Arrays.asList(summer1, summer2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.invokeAll(summers);
        Thread.sleep(100);
        executorService.shutdown();

        System.out.println("Sum is : " + sum.sum);
    }

    private static class Sum {
        final Object monitor = new Object();
        volatile long sum = 0;
    }

    private static class Summer implements Callable<Object> {
        private long[] data;
        private Sum sum;

        Summer(long[] data, Sum sum) {
            this.data = data;
            this.sum = sum;
        }

        public Object call() {
            for (Long number : data) {
                synchronized (sum.monitor) {
                    System.out.printf("%s: add %d to %d\n", Thread.currentThread().getName(), number, sum.sum);
                    sum.sum += number;
                }
            }

            return data;
        }
    }
}


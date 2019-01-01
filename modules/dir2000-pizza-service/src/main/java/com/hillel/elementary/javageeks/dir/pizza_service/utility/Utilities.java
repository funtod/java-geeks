package com.hillel.elementary.javageeks.dir.pizza_service.utility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Utilities {
    public static void shutdownAndAwaitTermination(ExecutorService pool, int time, TimeUnit timeUnit) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(time, timeUnit)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(time, timeUnit))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

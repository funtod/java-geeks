package com.hillel.elementary.javageeks.examples.threads.concurrent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleNonBlockingQueueTest {

    @Test
    void shouldAddAndDeleteElementConcurrently() throws InterruptedException, ExecutionException {
        SimpleNonBlockingQueue<Integer> queue = new SimpleNonBlockingQueue<>();
        Collection<Callable<Object>> threads = new ArrayList<>();
        AtomicInteger counter=  new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            int number = i;
            threads.add(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    queue.add(number);
                    return null;
                }
            });
            threads.add(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (int j = 0; j < 10; j++) {
                        Integer x = queue.poll();
                        if (x != null) {
                            System.out.println(x);
                            counter.incrementAndGet();
                        }
                    }
                    return null;
                }
            });
        }

        ExecutorService service = Executors.newFixedThreadPool(100);
        List<Future<Object>> futures = service.invokeAll(threads);
        service.awaitTermination(10000, TimeUnit.MILLISECONDS);
        assertThat(counter.get()).isEqualTo(100);
    }
}
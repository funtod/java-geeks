package com.hillel.elementary.javageeks.dir.concurrency.atomics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleNonBlockingQueueTest {
  private final SimpleNonBlockingQueue<Integer> queue = new SimpleNonBlockingQueue<>();
  private final Collection<Callable<Object>> threads = new ArrayList<>();
  private final AtomicInteger counter = new AtomicInteger();
  private final int THREAD_PAIRS_COUNT = 100;
  private final int READ_TRIES = 50;
  private final int MILLISECONDS_TO_AWAIT = 10000;

    //@Test
  void shouldAddAndDeleteElementConcurrently() throws InterruptedException, ExecutionException {
    for (int i = 0; i < THREAD_PAIRS_COUNT; i++) {
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
          for (int j = 0; j < READ_TRIES; j++) {
            Integer x = queue.poll();
            if (x != null) {
                //System.out.println(x);
              counter.incrementAndGet();
            }
          }
          return null;
        }
      });
    }

    ExecutorService service = Executors.newFixedThreadPool(THREAD_PAIRS_COUNT);
    List<Future<Object>> futures = service.invokeAll(threads);
    service.awaitTermination(MILLISECONDS_TO_AWAIT, TimeUnit.MILLISECONDS);
    assertThat(counter.get()).isEqualTo(THREAD_PAIRS_COUNT);
  }

    //@Test
  void shouldIterateOverQueueConcurrently() throws InterruptedException, ExecutionException {
    for (int i = 0; i < THREAD_PAIRS_COUNT; i++) {
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
          for (int j = 0; j < READ_TRIES; j++) {
            Integer x = queue.poll();
            if (x != null) {
              counter.incrementAndGet();
            }
          }
          return null;
        }
      });
      //to check that iterators don't fail and do not influence on usual queue work
      for (int j = 0; j < READ_TRIES; j++) {
        threads.add(new Callable<Object>() {
          @Override
          public Object call() throws Exception {
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                //System.out.println("An iterator says " + iterator.next());
            }
            return null;
          }
        });
      }
    }

    ExecutorService service = Executors.newFixedThreadPool(THREAD_PAIRS_COUNT);
    List<Future<Object>> futures = service.invokeAll(threads);
    service.awaitTermination(MILLISECONDS_TO_AWAIT, TimeUnit.MILLISECONDS);
    assertThat(counter.get()).isEqualTo(THREAD_PAIRS_COUNT);
  }
}
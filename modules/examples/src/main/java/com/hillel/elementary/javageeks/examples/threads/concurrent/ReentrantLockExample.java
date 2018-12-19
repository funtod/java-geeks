package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        final ProducerConsumer producerConsumer = new ProducerConsumer();

        final Thread consumer = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("Consumer: " +  producerConsumer.consume());
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("Consume Done.");
            }
        };

        consumer.start();
        final Random random = new Random();
        try {
            for (int i = 0; i < 10; i++) {
                final int value = random.nextInt();
                producerConsumer.produce(value);
            }
        } catch (InterruptedException e) {
            System.out.println("Produce interrupted.");
        }
        consumer.interrupt();
    }
}

class ProducerConsumer {
    private final Lock lock = new ReentrantLock();
    private final Condition empty = lock.newCondition();
    private final Condition filled = lock.newCondition();
    private int variable = -1;

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (variable == -1) {
                filled.await();
            }

            try {
                return variable;
            } finally {
                variable = -1;
                empty.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (variable != -1) {
                empty.await();
            }
            this.variable = value;
            System.out.println("Producer: " + variable);
            filled.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

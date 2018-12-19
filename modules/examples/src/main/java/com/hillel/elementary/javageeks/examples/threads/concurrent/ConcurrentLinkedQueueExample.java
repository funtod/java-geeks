package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    private Queue<String> queue;

    Producer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("Producer Started");
        try {
            for (int i = 1; i < 10; i++) {
                queue.add("String" + i);
                System.out.println("Added: String" + i);
                Thread.sleep(200);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private Queue<String> queue;

    Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        String str;
        System.out.println("Consumer Started");
        for (int x = 1; x < 10; ) {
            while ((str = queue.poll()) != null) {
                System.out.println("Removed: " + str);
                x++;
            }
        }
    }
}

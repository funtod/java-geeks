package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueExample {

    public static void main(String[] args) {
        LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<>();

        TransferProducer producer = new TransferProducer(lnkTransQueue);
        TransferConsumer consumer = new TransferConsumer(lnkTransQueue);
        producer.start();
        consumer.start();
    }
}

class TransferProducer extends Thread {
    private TransferQueue<String> lnkTransQueue;

    TransferProducer(TransferQueue<String> lnkTransQueue) {
        this.lnkTransQueue = lnkTransQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Producer is waiting to transfer...");
                lnkTransQueue.transfer("A" + i);
                System.out.println("producer transfered element: A" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TransferConsumer extends Thread {
    private TransferQueue<String> lnkTransQueue;

    TransferConsumer(TransferQueue<String> lnkTransQueue) {
        this.lnkTransQueue = lnkTransQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Consumer is waiting to take element...");
                String s = lnkTransQueue.take();
                System.out.println("Consumer received Element: " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

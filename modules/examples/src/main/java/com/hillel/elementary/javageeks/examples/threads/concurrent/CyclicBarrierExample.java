package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    static class MyThread extends Thread {
        private CyclicBarrier queue;
        private String id;

        public MyThread(CyclicBarrier queue, String id) {
            this.queue = queue;
            this.id = id;
        }

        public void run() {
            try {
                System.out.printf("Поток %s подошел к барьеру\n", id);
                queue.await();
                System.out.printf("Поток %s прошел барьер\n", id);
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class Hello implements Runnable {
        public void run() {
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        CyclicBarrier queue = new CyclicBarrier(5, hello);

        for (int i = 0; i < 7; i++) {
            new MyThread(queue, String.valueOf(i)).start();
        }
    }
}

class Ferry {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3, new FerryBoat());
        //Инициализируем барьер на три потока и таском, который будет выполняться, когда
        //у барьера соберется три потока. После этого, они будут освобождены.
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i, barrier)).start();
            Thread.sleep(400);
        }
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private int carNumber;
        private CyclicBarrier barrier;

        public Car(int carNumber, CyclicBarrier barrier) {
            this.carNumber = carNumber;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                barrier.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

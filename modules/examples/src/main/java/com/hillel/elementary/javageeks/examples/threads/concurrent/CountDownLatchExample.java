package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    static class HungryStudent implements Runnable {
        private CountDownLatch latch;

        HungryStudent(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                latch.await();
                System.out.println("Cтудент поел");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Kock implements Runnable {
        private CountDownLatch latch;
        private int id;

        Kock(CountDownLatch latch, int id) {
            this.latch = latch;
            this.id = id;
        }

        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Готова еда от Кок №" + id);
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        int numberOfDishesRequired = 5;
        CountDownLatch latch = new CountDownLatch(numberOfDishesRequired);
        new Thread(new HungryStudent(latch)).start();
        for (int i = 0; i < numberOfDishesRequired; i++)
            new Thread(new Kock(latch, i)).start();
    }
}

class Race {
    //Условная длина гоночной трассы
    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        //Создаем CountDownLatch на 8 "условий"
        CountDownLatch latch = new CountDownLatch(8);

        for (int i = 1; i <= 5; i++) {
            int carSpeed = (int) (Math.random() * 100 + 50);
            new Thread(new Car(latch, i, carSpeed)).start();
            Thread.sleep(100);
        }

        while (latch.getCount() > 3) //Проверяем, собрались ли все автомобили
            Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms

        Thread.sleep(1000);
        System.out.println("На старт!");
        latch.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        latch.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        latch.countDown();//Команда дана, уменьшаем счетчик на 1
        //счетчик становится равным нулю, и все ожидающие потоки
        //одновременно разблокируются
    }

    public static class Car implements Runnable {
        private CountDownLatch latch;
        private int carNumber;
        private int carSpeed;//считаем, что скорость автомобиля постоянная

        public Car(CountDownLatch latch, int carNumber, int carSpeed) {
            this.latch = latch;
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                //Автомобиль подъехал к стартовой прямой - условие выполнено
                //уменьшаем счетчик на 1
                latch.countDown();
                //метод await() блокирует поток, вызвавший его, до тех пор, пока
                //счетчик CountDownLatch не станет равен 0
                latch.await();
                Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

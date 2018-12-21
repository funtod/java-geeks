package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String args[]) throws Exception {
        //true –гарантия того, что первый поток который вызвал acquire получит доступ к блокируемому объекту
        Semaphore sem = new Semaphore(1, true);
        Thread thrdA = new Thread(new MyThread(sem, "Message 1"));
        Thread thrdB = new Thread(new MyThread(sem, "Message 2"));

        thrdA.start();
        thrdB.start();

        thrdA.join();
        thrdB.join();
    }

    static class MyThread implements Runnable {
        Semaphore semaphore;
        String message;

        MyThread(Semaphore semaphore, String message) {
            this.semaphore = semaphore;
            this.message = message;
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(message);
                Thread.sleep(10);

            } catch (Exception exc) {
                System.out.println("Error Writing Message");
            } finally {
                semaphore.release();
            }
        }
    }
}

class Parking {

    public static void main(String[] args) throws InterruptedException {
        //Парковочное место занято - true, свободно - false
        boolean[] parkingPlaces = new boolean[5];
        //Устанавливаем флаг "справедливый", в таком случае метод
        //aсquire() будет раздавать разрешения в порядке очереди
        Semaphore semaphore = new Semaphore(5, true);

        for (int i = 1; i <= 17; i++) {
            new Thread(new Car(i, semaphore, parkingPlaces)).start();
            Thread.sleep(400);
        }
    }

    public static class Car implements Runnable {
        private final int carNumber;
        private final Semaphore semaphore;
        private final boolean[] parkingPlaces;

        public Car(int carNumber, Semaphore semaphore, boolean[] parkingPlaces) {
            this.carNumber = carNumber;
            this.semaphore = semaphore;
            this.parkingPlaces = parkingPlaces;
        }

        @Override
        public void run() {
            System.out.printf("Автомобиль №%d подъехал к парковке.\n", carNumber);
            try {
                //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
                //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
                //пока семафор не разрешит доступ
                semaphore.acquire();

                int parkingNumber = -1;

                //Ищем свободное место и паркуемся
                synchronized (parkingPlaces) {
                    for (int i = 0; i < 5; i++)
                        if (!parkingPlaces[i]) {      //Если место свободно
                            parkingPlaces[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Автомобиль №%d припарковался на месте %d.\n", carNumber, i);
                            break;
                        }
                }

                Thread.sleep(2000);       //Уходим за покупками, к примеру

                synchronized (parkingPlaces) {
                    parkingPlaces[parkingNumber] = false;//Освобождаем место
                }

                System.out.printf("Автомобиль №%d покинул парковку.\n", carNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
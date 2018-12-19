package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        phaser.register(); //регистрируем главный поток в phaser

        System.out.println("Счетчик phaser`а: " + phaser.getPhase());

        new PhaserExample().testPhaser(phaser);//phaser waiting for 2 parties
        new PhaserExample().testPhaser(phaser);//phaser waiting for 3 parties
        new PhaserExample().testPhaser(phaser);//phaser waiting for 4 parties
        //когда все потоки стартанули, дерегестируем главный поток
        //чтобы барьер из 3 пропустил все потоки
        Thread.sleep(10);
        phaser.arriveAndDeregister();
        System.out.println("Дерегестрируем main");
        Thread.sleep(1000);
        System.out.println("Счетчик phaser`а: " + phaser.getPhase());
    }

    private void testPhaser(Phaser phaser) {
        int phaseNumber = phaser.register();
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " прибыл, номер фазы: " + phaseNumber);
                phaser.arriveAndAwaitAdvance();//поток регистрируется в phaser и стоит на ожидании
                System.out.println(Thread.currentThread().getName() + " после прохождения барьера");
            }
        }.start();
    }
}

class Bus {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);//Сразу регистрируем главный поток
        //Фазы 0 и 6 - это автобусный парк, 1 - 5 остановки

        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i < 5; i++) {           //Сгенерируем пассажиров на остановках
            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, i + 1, phaser));//Этот пассажир выходит на следующей

            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, 5, phaser));    //Этот пассажир выходит на конечной
        }

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("Автобус выехал из парка.");
                    phaser.arrive();//В фазе 0 всего 1 участник - автобус
                    break;
                case 6:
                    System.out.println("Автобус уехал в парк.");
                    phaser.arriveAndDeregister();//Снимаем главный поток, ломаем барьер
                    break;
                default:
                    int currentBusStop = phaser.getPhase();
                    System.out.println("Остановка № " + currentBusStop);

                    for (Passenger p : passengers)          //Проверяем, есть ли пассажиры на остановке
                        if (p.departure == currentBusStop) {
                            phaser.register();//Регистрируем поток, который будет участвовать в фазах
                            p.start();        // и запускаем
                        }

                    phaser.arriveAndAwaitAdvance();//Сообщаем о своей готовности
            }
        }
    }

    public static class Passenger extends Thread {
        private int departure;
        private int destination;
        private Phaser phaser;

        public Passenger(int departure, int destination, Phaser phaser) {
            this.departure = departure;
            this.destination = destination;
            this.phaser = phaser;
            System.out.println(this + " ждёт на остановке № " + this.departure);
        }

        @Override
        public void run() {
            try {
                System.out.println(this + " сел в автобус.");

                while (phaser.getPhase() < destination) //Пока автобус не приедет на нужную остановку(фазу)
                    phaser.arriveAndAwaitAdvance();     //заявляем в каждой фазе о готовности и ждем

                Thread.sleep(1);
                System.out.println(this + " покинул автобус.");
                phaser.arriveAndDeregister();   //Отменяем регистрацию на нужной фазе
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Пассажир{" + departure + " -> " + destination + '}';
        }
    }
}

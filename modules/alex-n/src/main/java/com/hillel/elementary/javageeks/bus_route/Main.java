package com.hillel.elementary.javageeks.bus_route;

public class Main {

    public static void main(String[] args) {

        Runner runner = new Runner(2, 10);

        new Thread(runner.new Bus(1, 1000, 2000)).start();
        new Thread(runner.new Bus(2, 1000, 2000)).start();
        new Thread(runner.new Bus(3, 1000, 2000)).start();
        new Thread(runner.new Bus(4, 1000, 2000)).start();
        new Thread(runner.new Bus(5, 1000, 2000)).start();
        new Thread(runner.new Bus(6, 1000, 2000)).start();
        new Thread(runner.new Bus(7, 1000, 2000)).start();
        new Thread(runner.new Bus(8, 1000, 2000)).start();
        new Thread(runner.new Bus(9, 1000, 2000)).start();
        new Thread(runner.new Bus(10, 1000, 2000)).start();
        new Thread(runner.new Bus(11, 1000, 2000)).start();
        new Thread(runner.new Bus(12, 1000, 2000)).start();
        new Thread(runner.new Bus(13, 1000, 2000)).start();
        new Thread(runner.new Bus(14, 1000, 2000)).start();
        new Thread(runner.new Bus(15, 1000, 2000)).start();
    }
}

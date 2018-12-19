package com.hillel.elementary.javageeks.bus_route;

public final class Main {

    private static final int SLEEP_ON_STOP_TIME = 1000;
    private static final int SLEEP_BETWEEN_STOPS_TIME = 2000;
    private static final int BUSES_ON_ROUTE = 10;
    private static final int STOPS = 10;
    private static final int MAX_BUSES_ON_STOP = 10;

    private Main() { }

    public static void main(String[] args) {

        Runner runner = new Runner(MAX_BUSES_ON_STOP, STOPS);

        for (int i = 0; i < BUSES_ON_ROUTE; i++) {
            new Thread(runner.new Bus(i, SLEEP_ON_STOP_TIME, SLEEP_BETWEEN_STOPS_TIME)).start();
        }
    }
}

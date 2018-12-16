package com.hillel.elementary.javageeks.bus_route;

public class Runner {

    private final Object monitor = new Object();
    private int maxBusesOnStop;
    private int[] stops;

    public Runner(int maxBusesOnStop, int stops) {
        this.maxBusesOnStop = maxBusesOnStop;
        this.stops = new int[stops];
    }

    class Bus implements Runnable {

        private int id;
        private int currentStop;
        private int sleepOnStopTime;
        private int sleepBetweenStopsTime;
        private boolean isOnStop = false;

        public Bus(int id, int sleepOnStopTime, int sleepBetweenStopsTime) {
            this.id = id;
            this.sleepOnStopTime = sleepOnStopTime;
            this.sleepBetweenStopsTime = sleepBetweenStopsTime;
        }

        @Override
        public void run() {
            System.out.println("bus #" + id + " starts the route");
            for (int i = 0; i < stops.length * 2; i++) {
                if (isOnStop) {
                    synchronized (monitor) {
                        stops[currentStop] = stops[currentStop] - 1;
                        monitor.notifyAll();
                    }
                    System.out.println("bus #" + id + " leaves the bus stop #" + currentStop);
                    currentStop++;
                    isOnStop = false;
                    try {
                        Thread.sleep(sleepBetweenStopsTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    synchronized (monitor) {
                        while (stops[currentStop] >= maxBusesOnStop) {
                            System.out.println("bus #" + id + " is waiting for a free space on stop #" + currentStop);
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        stops[currentStop] = stops[currentStop] + 1;
                    }
                    System.out.println("bus #" + id + " is stopped on bus stop #" + currentStop);
                    isOnStop = true;
                    try {
                        Thread.sleep(sleepOnStopTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("bus #" + id + "ended the route.");
        }
    }
}

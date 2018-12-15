package com.hillel.elementary.javageeks.examples.threads.volatil;

public class VolatileExampleVisibility {
    private int years;
    private int months;
    private volatile int days; //если убрать, не будут обновляться данные в потоках чтения

    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days) {
        this.days = days;
        this.years = years;
        this.months = months;
    }

    public static void main(String[] args) {
        VolatileExampleVisibility example = new VolatileExampleVisibility();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    example.update(i, i, i);
                    System.out.println("Updated to " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int lastValue = 0;
                while (lastValue < 3564) {
                    int totalDays = example.totalDays();
                    if (lastValue != totalDays) {
                        System.out.println("value is " + totalDays);
                    }
                    lastValue = totalDays;
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}

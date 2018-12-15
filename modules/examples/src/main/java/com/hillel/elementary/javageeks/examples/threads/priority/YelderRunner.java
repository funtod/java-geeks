package com.hillel.elementary.javageeks.examples.threads.priority;

public class YelderRunner {

    public static void main(String[] args) {
        int numberOfCycles = 5;
        Yielder yielder = new Yielder(numberOfCycles);
        yielder.setPriority(Thread.MAX_PRIORITY);
        yielder.setName("Yielder");
        yielder.start();

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < numberOfCycles; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
}

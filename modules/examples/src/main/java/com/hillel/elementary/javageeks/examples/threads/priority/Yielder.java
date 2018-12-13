package com.hillel.elementary.javageeks.examples.threads.priority;

class Yielder extends Thread {
    private int howOften;

    public Yielder(int howOften) {
        this.howOften = howOften;
    }

    public void run() {
        for (int i = 0; i < howOften; i++) {
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
}

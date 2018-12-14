package com.hillel.elementary.javageeks.examples.threads.tasks.counter;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        CounterTask counterTask = new CounterTask();

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(counterTask.new TestTask()));
        }
        System.out.println("Starting threads");
        for (int i = 0; i < 100; i++) {
            threads.get(i).start();
        }
        try {
            for (int i = 0; i < 100; i++) {
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter=" + counterTask.getCounter());
    }

}

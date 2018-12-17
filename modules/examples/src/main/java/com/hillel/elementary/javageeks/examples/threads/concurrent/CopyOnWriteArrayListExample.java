package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                numbers.add(10);
                System.out.println("numbers: " + numbers);
            }
        };

        thread1.start();

        for (int i : numbers) {
            thread1.join();
            System.out.println(i);  // не напечатеат 10, т.к. снимок массива был взят до добавления 10
        }
    }
}

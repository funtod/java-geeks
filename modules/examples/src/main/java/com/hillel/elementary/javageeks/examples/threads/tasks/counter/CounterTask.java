package com.hillel.elementary.javageeks.examples.threads.tasks.counter;

/**
 * Есть счетчик, подсчитывающий количество вызовов.
 * <p>
 * Почему счетчик показывает разные значения и не считает до конца?
 * Как это можно исправить?
 * <p>
 * Попробуйте закомментировать обращение к yield().
 * Измениться ли значение?
 */
public class CounterTask {
    private int counter = 0;

    class TestTask implements Runnable {
                @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter++;
                Thread.yield();
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
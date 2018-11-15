package com.hillel.elementary.javageeks.task4;

public class SomeClass {

    private static int apples = 100;

    public static int eatApples(int applesToEat, int numberOfAttempts)
            throws Exception {

        try {
            int result = apples - applesToEat;
            if (result >= 0) {
                apples = result;
                return apples;
            }
            throw new RuntimeException("Not enough apples!");
        } catch (RuntimeException e) {
            for (int i = 0; i < numberOfAttempts; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    System.out.println("Thread can't wait");
                }
                int result = apples - applesToEat;
                if (result >= 0) {
                    apples = result;
                    return result;
                }
            }
            throw new Exception("There were not enough apples to eat");
        }
    }
}

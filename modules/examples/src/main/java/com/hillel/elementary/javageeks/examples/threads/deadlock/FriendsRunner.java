package com.hillel.elementary.javageeks.examples.threads.deadlock;

public class FriendsRunner {

    public static void main(String[] args) throws InterruptedException {
        Friend jareth = new Friend("Jareth");
        Friend cory = new Friend("Cory");

        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++)
                    jareth.hug();
            }
        }, "thread1");

        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++)
                    cory.hug();
            }
        }, "thread2");

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
        threadOne.interrupt();
    }
}

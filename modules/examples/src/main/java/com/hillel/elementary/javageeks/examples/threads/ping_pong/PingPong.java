package com.hillel.elementary.javageeks.examples.threads.ping_pong;

public class PingPong extends Thread {

    private String word;
    private int delay; // длительность паузы

    PingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                System.out.println(word + " ");
                sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

}
package com.hillel.elementary.javageeks.examples.threads.ping_pong;

public class PingPongRunner {

    public static void main(String[] args) {
        Thread ping = new PingPong("ping", 33);
        Thread pong = new PingPong("PONG", 100);
        ping.start(); // 1/30 секунды
        pong.start(); // 1/10 секунды
    }
}

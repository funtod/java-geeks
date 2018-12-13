package com.hillel.elementary.javageeks.examples.threads.ping_pong;

public class RunPingPongRunner {

    public static void main(String[] args) {
        Runnable ping = new PingPong("ping", 33);
        Runnable pong = new PingPong("PONG", 100);
        new Thread(ping).start();
        new Thread(pong).start();
    }
}

package com.hillel.elementary.javageeks.artem.chat;

public class ClientRunner {
    public static void main(String[] args) {
        new Thread(new Output()).start();
    }
}

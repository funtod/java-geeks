package com.hillel.elementary.javageeks.messenger.client;

public final class ClientRunner {

    private ClientRunner() {
    }

    public static void main(String[] args) {
        new Thread(new OutputThread()).start();
    }
}

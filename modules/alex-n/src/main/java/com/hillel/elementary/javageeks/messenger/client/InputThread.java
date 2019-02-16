package com.hillel.elementary.javageeks.messenger.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRunner.class);
    private Socket socket;

    InputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(socket.getInputStream())) {
            while (!Thread.currentThread().isInterrupted()) {
                if (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            }
        } catch (IOException e) {
            String errorMsg = "Can't read messages from server";
            LOGGER.error(errorMsg + e);
            throw new IllegalStateException(errorMsg, e);
        }
    }
}

package com.hillel.elementary.javageeks.messenger.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRunner.class);
    private static final int TIMEOUT = 2000;

    OutputThread() {
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            Socket socket = new Socket();
            System.out.println("What is your name (gonna be visible in chat)?:");
            String userName = scanner.nextLine().trim();
            System.out.println("Enter the host please:");
            String host = scanner.nextLine().trim();
            System.out.println("Enter the port please:");
            int port = Integer.parseInt(scanner.nextLine());

            socket.connect(new InetSocketAddress(host, port), TIMEOUT);
            LOGGER.info("Connected to the: " + host + ":" + port);
            Thread inputThread = new Thread(new InputThread(socket));
            inputThread.start();

            try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                writer.println(userName);

                boolean running = true;
                while (running) {
                    if (scanner.hasNext()) {
                        String msg = scanner.nextLine();
                        writer.println(msg);
                        running = !msg.trim().equalsIgnoreCase("bye");
                    }
                }
                inputThread.interrupt();
            }
        } catch (IOException e) {
            String exceptionMsg = "Can't continue due to IO exception";
            LOGGER.error(exceptionMsg, e);
            throw new IllegalStateException(exceptionMsg, e);
        }
    }
}

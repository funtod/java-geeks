package com.hillel.elementary.javageeks.messenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public final class Server {

    private static HashMap<String, PrintWriter> userWriters = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private Server() {
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(getPortNumber())) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new UserThread(socket)).start();
            }
        } catch (IOException e) {
            LOGGER.error("Can not open the server socket", e);
        }
    }

    private static Integer getPortNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter server port number plz: ");
            Integer port = Integer.parseInt(scanner.next());
            LOGGER.info("Starting server at port " + port);
            return port;
        }
    }

    private static synchronized void msgToAll(String msg) {
        if (msg != null && !msg.isEmpty()) {
            for (PrintWriter writer : userWriters.values()) {
                writer.println(msg);
            }
        }
    }

    private static synchronized void closeUserConnection(String userName) {
        String userDisconnectedMsg = String.format("user %s - disconnected", userName);
        msgToAll(userDisconnectedMsg);
        LOGGER.info(userDisconnectedMsg);
        userWriters.get(userName).close();
        userWriters.remove(userName);
    }


    private static class UserThread implements Runnable {

        private Socket userSocket;
        String userName;

        UserThread(Socket userSocket) {
            this.userSocket = userSocket;
        }

        @Override
        public void run() {

            try (Scanner scanner = new Scanner(userSocket.getInputStream())) {
                try (PrintWriter writer = new PrintWriter(userSocket.getOutputStream(), true)) {

                    userName = scanner.nextLine();
                    LOGGER.info(String.format("new user: %s connected to the server%n", userName));
                    String welcomingMsg = String.format("[Server]: Hello %s. welcome to the chat.", userName);
                    writer.println(welcomingMsg);
                    userWriters.put(userName, writer);

                    boolean running = true;
                    while (running) {
                        if (scanner.hasNext()) {
                            String userInput = scanner.nextLine();
                            String msg = String.format("[%s]: %s", userName, userInput);
                            msgToAll(msg);
                            if (userInput != null && userInput.trim().equalsIgnoreCase("bye")) {
                                closeUserConnection(userName);
                                userSocket.close();
                                running = false;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                LOGGER.error(String.format("IO Exception with user [%s]:", userName), e);
            }
        }
    }
}


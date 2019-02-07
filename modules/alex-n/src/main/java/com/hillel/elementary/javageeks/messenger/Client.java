package com.hillel.elementary.javageeks.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public final class Client {

    private static boolean running = true;
    private static final int TIMEOUT = 2000;

    private Client() {
    }

    public static void main(String[] args) {
        new Thread(new UserOutputThread()).start();
    }


    private static class ChatFeedThread implements Runnable {

        private Socket socket;

        ChatFeedThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Scanner scanner = new Scanner(socket.getInputStream())) {
                while (running) {
                    if (scanner.hasNext()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static class UserOutputThread implements Runnable {

        private UserOutputThread() {
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
                System.out.println("Connected to the: " + host + ":" + port);
                new Thread(new ChatFeedThread(socket)).start();

                try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                    writer.println(userName);

                    while (running) {
                        if (scanner.hasNext()) {
                            String msg = scanner.nextLine();
                            writer.println(msg);
                            running = !msg.trim().equalsIgnoreCase("bye");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

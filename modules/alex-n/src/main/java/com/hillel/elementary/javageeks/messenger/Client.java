package com.hillel.elementary.javageeks.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public final class Client {

    private static boolean running = true;
    private static final String USER_NAME = "Alexander";
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final int TIMEOUT = 2000;


    private Client() {
    }

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
        System.out.println("Connected to the: " + HOST + ":" + PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(USER_NAME);
        new Thread(new UserOutputThread(socket)).start();
        new Thread(new ChatFeedThread(socket)).start();
    }


    static class ChatFeedThread implements Runnable {

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


    static class UserOutputThread implements Runnable {

        private Socket socket;

        UserOutputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Scanner scanner = new Scanner(System.in)) {
                while (running) {
                    if (scanner.hasNext()) {
                        String msg = scanner.nextLine();
                        new PrintWriter(socket.getOutputStream(), true).println(msg);
                        running = !msg.trim().equalsIgnoreCase("bye");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.hillel.elementary.javageeks.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static boolean running = true;
    private final static String USER_NAME = "Alexander";
    private final static String HOST = "localhost";
    private final static int PORT = 8080;


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(HOST, PORT), 2000);
        System.out.println("Connected to the: " + HOST + ":" + PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(USER_NAME);
        new Thread(new UserOutputThread(socket)).start();
        new Thread(new ChatFeedThread(socket)).start();
//        writer.close();
    }

    static class ChatFeedThread implements Runnable {

        Socket socket;

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

        Socket socket;

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

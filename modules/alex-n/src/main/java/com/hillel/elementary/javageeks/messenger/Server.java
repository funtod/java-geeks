package com.hillel.elementary.javageeks.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public final class Server {

    private static HashMap<String, Socket> userConnections = new HashMap<>();

    private Server() {
    }

    public static void main(String[] args) {

        boolean running = true;
        Scanner scanner;

        try (ServerSocket serverSocket = new ServerSocket(getPortNumber())) {
            String userName;
            while (running) {
                Socket socket = serverSocket.accept();
                scanner = new Scanner(socket.getInputStream());
                userName = scanner.nextLine();

                System.out.printf("new user: %s connected to the server%n", userName);
                String welcomingMsg = String.format("Hello %s. welcome to the chat.", userName);
                new PrintWriter(socket.getOutputStream(), true).println(welcomingMsg);
                userConnections.put(userName, socket);
                new Thread(new UserThread(socket, userName)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer getPortNumber() {
        System.out.println("Enter server port number plz: ");
        Scanner scanner = new Scanner(System.in);
        Integer port = Integer.parseInt(scanner.next());
        System.out.println("Starting server at port " + port);
        return port;
    }


    private static class UserThread implements Runnable {

        private Socket userSocket;
        private String userName;

        UserThread(Socket userSocket, String userName) {
            this.userSocket = userSocket;
            this.userName = userName;
        }

        @Override
        public void run() {
            try (Scanner scanner = new Scanner(userSocket.getInputStream())) {
                boolean running = true;
                while (running) {
                    if (scanner.hasNext()) {
                        String userInput = scanner.nextLine();
                        String msg = String.format("[%s]: %s", userName, userInput);
                        msgToAll(msg);
                        if (userInput.trim().equalsIgnoreCase("bye")) {
                            closeUserConnection();
                            running = false;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void closeUserConnection() throws IOException {
            String userDisconnectedMsg = String.format("user %s - disconnected", userName);
            msgToAll(userDisconnectedMsg);
            System.out.println(userDisconnectedMsg);
            userConnections.remove(userName);
            userSocket.close();
        }

        void msgToAll(String msg) throws IOException {
            Collection<Socket> connections = userConnections.values();
            for (Socket socket : connections) {
                new PrintWriter(socket.getOutputStream(), true).println(msg);
            }
        }
    }
}


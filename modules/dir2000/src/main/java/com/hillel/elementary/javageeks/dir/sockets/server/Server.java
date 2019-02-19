package com.hillel.elementary.javageeks.dir.sockets.server;

import com.hillel.elementary.javageeks.dir.sockets.Logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final int PORT = 5000;
    CopyOnWriteArraySet<Socket> clientSockets;
    ExecutorService executor;

    public Server() {
        clientSockets = new CopyOnWriteArraySet<>();
        executor = Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        new Server().go();
    }

    public void go() {
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(PORT);
        } catch (IOException ex) {
            Logging.logFailure(ex);
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            Thread serverThread = new Thread(new ServerTask(this, serverSock));
            serverThread.start();

            String prompt = "Enter \"shutdown\" to stop the server...";
            System.out.println(prompt);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("shutdown")) {
                    break;
                } else {
                    System.out.println(prompt);
                }
            }
            System.out.println("Shutdown command accepted.");
            serverSock.close();
            serverThread.join();
            for (Socket socket : clientSockets) {
                socket.close();
            }
        } catch (IOException ex) {
            Logging.logFailure(ex);
        } catch (InterruptedException ex) {
            Logging.logFailure(ex);
        }
    }

    public void tellEveryone(String message) {
        Iterator<Socket> it = clientSockets.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = new PrintWriter(it.next().getOutputStream());
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {
                Logging.logFailure(ex);
            }
        }
    }


}

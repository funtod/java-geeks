package com.hillel.elementary.javageeks.artem.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ServerInput implements Runnable{

    private Logger LOG = LoggerFactory.getLogger(ServerRunner.class);
    public static HashMap<String, PrintWriter> users = ServerOptions.getMapOfUsers();
    private Socket socket;
    String name;

    public ServerInput(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (Scanner scanner = new Scanner(socket.getInputStream())) {
            try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                name = scanner.nextLine();
                LOG.info(name + " connected.");
                users.put(name, writer);

                boolean run = true;
                while (run) {
                    if (scanner.hasNext()) {
                        String text = scanner.nextLine();
                        String messageToAll = name + ": " + text;
                        ServerOptions.messageToUsers(messageToAll);
                        if (text != null && text.trim().equalsIgnoreCase("bye")) {
                            ServerOptions.userDisconect(name);
                            socket.close();
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error(String.valueOf(e));
        }
    }
}

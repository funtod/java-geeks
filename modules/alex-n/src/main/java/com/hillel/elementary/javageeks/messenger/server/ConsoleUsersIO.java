package com.hillel.elementary.javageeks.messenger.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ConsoleUsersIO implements UsersIO {

    private static final List<PrintWriter> usersWriters = Collections.synchronizedList(new ArrayList<>());
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerRunner.class);

    private Scanner scanner;
    private PrintWriter writer;

    ConsoleUsersIO(Socket socket) {
        try {
            scanner = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream(), true);
            usersWriters.add(writer);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Can't start messaging with server", e);
        }
    }

    @Override
    public void msgToAll(String msg) {
        synchronized (usersWriters) {
            if (msg != null && !msg.isEmpty()) {
                for (PrintWriter writer : usersWriters) {
                    writer.println(msg);
                }
            }
        }
    }

    @Override
    public void msgToAll(String msg, String user) {
        String userMsg = String.format("[%s]: %s", user, msg);
        msgToAll(userMsg);
    }

    @Override
    public String getUserName() {
        return scanner.nextLine();
    }

    @Override
    public void wellComeUser(String userName) {
        String welcomingMsg = String.format("[Server]: Hello %s. welcome to the chat.", userName);
        writer.println(welcomingMsg);
    }

    @Override
    public String getUserMsg() {
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }else {
            return "";
        }
    }

    @Override
    public void close() {
        usersWriters.remove(writer);
        scanner.close();
        writer.close();
    }
}

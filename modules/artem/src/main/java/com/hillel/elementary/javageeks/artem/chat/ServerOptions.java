package com.hillel.elementary.javageeks.artem.chat;

import com.hillel.elementary.javageeks.artem.chat.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class ServerOptions {


    private static Logger LOG = LoggerFactory.getLogger(Server.class);
    public static HashMap<String, PrintWriter> users = new HashMap<>();

    public static HashMap<String, PrintWriter> getMapOfUsers(){
        return users;
    }

    public static synchronized void messageToUsers(String message) {
        if (message != null && !message.isEmpty()) {
            for (PrintWriter writer : users.values()) {
                writer.println(message);
            }
        }
    }

    public static synchronized void userDisconect(String name) {
        String userDisconnected = "user " + name + " disconnected";
        messageToUsers(userDisconnected);

        LOG.info(userDisconnected);

        users.get(name).close();
        users.remove(name);
    }

    public static Integer getNumberOfPort() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Server port: ");
            Integer port = Integer.parseInt(scanner.next());
            LOG.info("Server started.");
            return port;
        }
    }
}

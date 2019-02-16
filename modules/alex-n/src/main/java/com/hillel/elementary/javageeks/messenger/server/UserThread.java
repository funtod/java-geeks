package com.hillel.elementary.javageeks.messenger.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UserThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerRunner.class);
    private UsersIO usersIO;

    UserThread(UsersIO usersIO) {
        this.usersIO = usersIO;
    }

    @Override
    public void run() {

        String userName = usersIO.getUserName();
        LOGGER.info(String.format("new user: %s connected to the server%n", userName));
        usersIO.wellComeUser(userName);

        boolean running = true;
        while (running) {
            String msg = usersIO.getUserMsg();
            if (msg.trim().equals("bye")) {
                String userDisconnectedMsg = String.format("User %s disconnected", userName);
                usersIO.msgToAll(String.format(userDisconnectedMsg, userName), "Server");
                LOGGER.info(userDisconnectedMsg);
                usersIO.close();
                running = false;
            } else if (!msg.isEmpty()) {
                usersIO.msgToAll(msg, userName);
            }
        }
    }
}

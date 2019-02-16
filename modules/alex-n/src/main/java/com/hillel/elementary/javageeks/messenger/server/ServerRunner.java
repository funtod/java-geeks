package com.hillel.elementary.javageeks.messenger.server;

import com.hillel.elementary.javageeks.messenger.server.utils.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServerRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerRunner.class);

    private ServerRunner() {
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerService.getPortNumber())) {
            while (true) {
                Socket socket = serverSocket.accept();
                UsersIO usersIO = new ConsoleUsersIO(socket);
                new Thread(new UserThread(usersIO)).start();
            }
        } catch (IOException e) {
            LOGGER.error("Can not open the server socket", e);
        }
    }
}


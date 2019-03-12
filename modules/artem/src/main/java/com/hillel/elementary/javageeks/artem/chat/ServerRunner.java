package com.hillel.elementary.javageeks.artem.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {

     private static Logger LOG = LoggerFactory.getLogger(ServerRunner.class);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerOptions.getNumberOfPort())) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerInput(socket)).start();
            }
        } catch (IOException e) {
            LOG.error(String.valueOf(e));
        }
    }
}

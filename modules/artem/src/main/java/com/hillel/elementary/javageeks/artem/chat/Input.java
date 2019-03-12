package com.hillel.elementary.javageeks.artem.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Input implements Runnable{

    private Socket socket;
    private Logger LOG = LoggerFactory.getLogger(ClientRunner.class);

    Input(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(socket.getInputStream())) {

            while (true) {
            if (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
            }
            }
        } catch (IOException e) {
          LOG.error(String.valueOf(e));
        }
    }
}

package com.hillel.elementary.javageeks.artem.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Output implements Runnable {

    private Logger LOG = LoggerFactory.getLogger(ClientRunner.class);

    @Override
    public void run() {
    try (Scanner scanner = new Scanner(System.in)) {

    System.out.println("Your name:");
    String name = scanner.nextLine().trim();
    System.out.println("Host:");
    String host = scanner.nextLine().trim();
    System.out.println("Port:");
    int port = Integer.parseInt(scanner.nextLine());

    Socket socket = new Socket();
    socket.connect(new InetSocketAddress(host, port));
    LOG.info("You connected to the: " + host + ":" + port);
    Input input = new Input(socket);
    new Thread(input).start();

    try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
        writer.println(name);
        boolean run = true;
        while (run) {
            if (scanner.hasNext()) {
               String message = scanner.nextLine();
               writer.println(message);
               run = !message.trim().equalsIgnoreCase("bye");
               }
               }
            }
        } catch (IOException e) {
            LOG.error(String.valueOf(e));
        }
    }
}


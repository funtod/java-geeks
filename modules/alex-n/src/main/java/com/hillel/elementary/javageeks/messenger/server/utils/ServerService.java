package com.hillel.elementary.javageeks.messenger.server.utils;

import com.hillel.elementary.javageeks.messenger.server.ServerRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ServerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerRunner.class);

    public static Integer getPortNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter server port number plz: ");
            Integer port = Integer.parseInt(scanner.next());
            LOGGER.info("Starting server at port " + port);
            return port;
        }
    }
}
package com.hillel.elementary.javageeks.dir.sockets.server;

import com.hillel.elementary.javageeks.dir.sockets.Logging;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Server server;
    private Socket clientSocket;

    public ClientHandler(Server server, Socket argClientSocket) {
        this.server = server;
        clientSocket = argClientSocket;
    }

    public void run() {
        String message;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while ((message = reader.readLine()) != null) {
                if (message.equalsIgnoreCase("bye")) {
                    clientSocket.close();
                    server.clientSockets.remove(clientSocket);
                    return;
                }
                server.tellEveryone(message);
            }
        } catch (Exception ex) {
            if (!ex.getMessage().equals("Socket closed")) {
                Logging.logFailure(ex);
            }
        }
    }
}

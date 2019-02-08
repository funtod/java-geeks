package com.hillel.elementary.javageeks.dir.sockets.server;

import com.hillel.elementary.javageeks.dir.sockets.Logging;

import java.net.ServerSocket;
import java.net.Socket;

class ServerTask implements Runnable {
    private Server server;
    private ServerSocket serverSock;

    public ServerTask(Server server, ServerSocket serverSock) {
        this.server = server;
        this.serverSock = serverSock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket clientSocket = serverSock.accept();
                server.clientSockets.add(clientSocket);
                server.executor.execute(new ClientHandler(server, clientSocket));
            }
        } catch (Exception ex) {
            if (!ex.getMessage().equals("Socket closed")) {
                Logging.logFailure(ex);
            }
        }
    }
}

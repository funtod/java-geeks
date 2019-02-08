package com.hillel.elementary.javageeks.dir.sockets.client;

import com.hillel.elementary.javageeks.dir.sockets.Logging;

import java.io.IOException;

class IncomingReader implements Runnable {
    private Client client;

    public IncomingReader(Client client) {
        this.client = client;
    }

    public void run() {
        String message;
        try {
            while ((message = client.reader.readLine()) != null) {
                client.incoming.append(message + "\n");
            }
        } catch (IOException ex) {
            if (!ex.getMessage().equals("Socket closed")) {
                Logging.logFailure(ex);
            }
        }
        client.isAlive = false;
    }
}

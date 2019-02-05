package com.hillel.elementary.javageeks.dir.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.*;

public class Server {
  ExecutorService executor;
  CopyOnWriteArraySet<PrintWriter> clientOutputStreams;

  public Server() {
    executor = Executors.newCachedThreadPool(
            new ThreadFactory() {
              public Thread newThread(Runnable r) {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setDaemon(true);
                return t;
              }
            });
  }

  public static void main(String[] args) {
    new Server().go();
  }

  public void go() {
    clientOutputStreams = new CopyOnWriteArraySet<>();
    try {
      ServerSocket serverSock = new ServerSocket(5000);
      while (true) {
        Socket clientSocket = serverSock.accept();
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        clientOutputStreams.add(writer);

        executor.execute(new ClientHandler(clientSocket));
        System.out.println("got a connection");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    executor.shutdownNow();
  }

  public void tellEveryone(String message) {
    Iterator<PrintWriter> it = clientOutputStreams.iterator();
    while (it.hasNext()) {
      try {
        PrintWriter writer = it.next();
        writer.println(message);
        writer.flush();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public class ClientHandler implements Runnable {
    BufferedReader reader;
    Socket sock;

    public ClientHandler(Socket clientSOcket) {
      try {
        sock = clientSOcket;
        InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
        reader = new BufferedReader(isReader);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    public void run() {
      String message;
      try {
        while ((message = reader.readLine()) != null) {
          System.out.println("read " + message);
          if (message.equalsIgnoreCase("bye")) {
            sock.close();
            clientOutputStreams.remove(sock);
            return;
          }
          tellEveryone(message);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}

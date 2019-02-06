package com.hillel.elementary.javageeks.dir.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.*;

public class Server {
  ConcurrentHashMap<Socket, PrintWriter> clientOutputStreams;
  ExecutorService executor;

  public Server() {
    clientOutputStreams = new ConcurrentHashMap<>();
    executor = Executors.newCachedThreadPool();
  }

  public static void main(String[] args) {
    new Server().go();
  }

  public void go() {
    executor.execute(new ServerTask());

    try (Scanner scanner = new Scanner(System.in)) {
      String prompt = "Enter \"shutdown\" to stop the server...";
      System.out.println(prompt);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.equalsIgnoreCase("shutdown")) {
          break;
        } else {
          System.out.println(prompt);
        }
      }
    }
    executor.shutdownNow();
    System.out.println("Shutdown command accepted.");
  }


  public void tellEveryone(String message) {
    Iterator<PrintWriter> it = clientOutputStreams.values().iterator();
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

  private class ServerTask implements Runnable {
    @Override
    public void run() {
      try (ServerSocket serverSock = new ServerSocket(5000);) {
        while (!Thread.currentThread().isInterrupted()) {
          Socket clientSocket = serverSock.accept();
          PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
          clientOutputStreams.put(clientSocket, writer);

          executor.execute(new ClientHandler(clientSocket));
          System.out.println("got a connection");
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  private class ClientHandler implements Runnable {
    Socket clientSocket;

    public ClientHandler(Socket argClientSocket) {
      try {
        clientSocket = argClientSocket;
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    public void run() {
      String message;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
        while ((message = reader.readLine()) != null) {
          System.out.println("read " + message);
          if (message.equalsIgnoreCase("bye")) {
            clientSocket.close();
            clientOutputStreams.remove(clientSocket);
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

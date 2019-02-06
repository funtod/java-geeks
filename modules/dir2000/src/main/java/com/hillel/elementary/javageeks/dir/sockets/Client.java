package com.hillel.elementary.javageeks.dir.sockets;


import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Client {
  JFrame frame;
  JTextArea incoming;
  JTextField outgoing;
  BufferedReader reader;
  PrintWriter writer;
  Socket sock;
  volatile boolean isAlive;

  public static void main(String[] args) {
    new Client().go();
  }

  public void go() {
    frame = new JFrame("Ludicrously Simple Chat Client");
    JPanel mainPanel = new JPanel();
    incoming = new JTextArea(15, 50);
    incoming.setLineWrap(true);
    incoming.setWrapStyleWord(true);
    incoming.setEditable(false);
    JScrollPane qScroller = new JScrollPane(incoming);
    qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    outgoing = new JTextField(20);
    JButton sendButton = new JButton("Send");
    sendButton.addActionListener(new SendButtonListener());
    mainPanel.add(qScroller);
    mainPanel.add(outgoing);
    mainPanel.add(sendButton);
    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        try {
          if (!sock.isClosed()) {
            sock.close();
          }
        } catch (IOException argE) {
          argE.printStackTrace();
        }
      }
    });

    setUpNetworking();

    Thread readerThread = new Thread(new IncomingReader());
    readerThread.setDaemon(true);
    readerThread.start();

    frame.setSize(650, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }

  private void setUpNetworking() {
    try {
      sock = new Socket("127.0.0.1", 5000);
      isAlive = true;
      InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
      reader = new BufferedReader(streamReader);
      writer = new PrintWriter(sock.getOutputStream());
      System.out.println("networking established");
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Couldn't connect to server.");
    }
  }

  public class SendButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
      try {
        if (isAlive) {
          writer.println(outgoing.getText());
          writer.flush();
        } else {
          JOptionPane.showMessageDialog(frame, "Disconnected");
          return;
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
      outgoing.setText("");
      outgoing.requestFocus();
    }
  }

  class IncomingReader implements Runnable {
    public void run() {
      String message;
      try {
        while ((message = reader.readLine()) != null) {
          System.out.println("client read " + message);
          incoming.append(message + "\n");
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      isAlive = false;
    }
  }
}
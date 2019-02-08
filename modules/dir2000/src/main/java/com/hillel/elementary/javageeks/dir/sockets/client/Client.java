package com.hillel.elementary.javageeks.dir.sockets.client;


import com.hillel.elementary.javageeks.dir.sockets.Logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 5000;
    private static final String USERNAME = "Zhurylo Michaylo";
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
        buildGui();
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader(this));
        readerThread.start();

        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGui() {
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
        sendButton.addActionListener(new SendButtonListener(this));
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
                } catch (IOException ex) {
                    Logging.logFailure(ex);
                }
            }
        });
    }

    private void setUpNetworking() {
        try {
            sock = new Socket(HOST, PORT);
            isAlive = true;
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            writer = new PrintWriter(sock.getOutputStream());
            writer.println(USERNAME);
            writer.flush();
        } catch (IOException ex) {
            Logging.logFailure(ex);
            throw new IllegalStateException("Couldn't connect to server.", ex);
        }
    }

}

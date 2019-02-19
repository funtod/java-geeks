package com.hillel.elementary.javageeks.dir.sockets.client;

import com.hillel.elementary.javageeks.dir.sockets.Logging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {
    private Client client;

    public SendButtonListener(Client client) {
        this.client = client;
    }

    public void actionPerformed(ActionEvent ev) {
    try {
      if (client.isAlive) {

        String text = client.outgoing.getText();
        if (text.trim().equals("")) {
          return;
        }
        client.writer.println(text);
        client.writer.flush();

        client.outgoing.setText("");
        client.outgoing.requestFocus();
      } else {
        JOptionPane.showMessageDialog(client.frame, "Disconnected");
        return;
      }
    } catch (Exception ex) {
      Logging.logFailure(ex);
    }
  }
}

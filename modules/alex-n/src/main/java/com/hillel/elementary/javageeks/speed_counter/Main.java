package com.hillel.elementary.javageeks.speed_counter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SpeedCounterGUI scg = new SpeedCounterGUI();
        JFrame frame = new JFrame();
        frame.setContentPane(scg.basePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(scg.basePanel.getSize());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

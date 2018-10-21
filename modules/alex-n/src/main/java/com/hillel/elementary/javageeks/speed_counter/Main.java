package com.hillel.elementary.javageeks.speed_counter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SpeedCounterGUI scg = new SpeedCounterGUI();
        JFrame frame = new JFrame();
        frame.setContentPane(scg.panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(scg.panel1.getSize());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

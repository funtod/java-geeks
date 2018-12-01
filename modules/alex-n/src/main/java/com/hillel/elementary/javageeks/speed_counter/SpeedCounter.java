package com.hillel.elementary.javageeks.speed_counter;

import javax.swing.*;

public final class SpeedCounter {

    private SpeedCounter() { }

    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static void runGui() {
        SpeedCounterGUI scg = new SpeedCounterGUI();
        JFrame frame = new JFrame();
        frame.setContentPane(scg.getBasePanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(scg.getBasePanel().getSize());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static float countSpeedInMetersPerSecond(int meters, int hours, int minutes, int seconds) {
        return  (float) meters / (hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds);
    }
}

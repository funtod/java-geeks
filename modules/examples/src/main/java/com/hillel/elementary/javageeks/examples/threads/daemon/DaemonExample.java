package com.hillel.elementary.javageeks.examples.threads.daemon;

public class DaemonExample extends Thread {

    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("старт потока-демона");
                sleep(1000);
            } else {
                System.out.println("старт обычного потока");
                sleep(10);
            }

        } catch (InterruptedException e) {
            System.out.print("Error" + e);
        } finally {
            if (!isDaemon())
                System.out.println("завершение работы обычного потока");
            else
                System.out.println("завершение работы потока-демона");
        }
    }

    public static void main(String[] args) {
        DaemonExample thread = new DaemonExample();
        DaemonExample daemonThread = new DaemonExample();

        daemonThread.setDaemon(true);

        daemonThread.start();
        thread.start();
    }
}
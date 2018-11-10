package com.hillel.elementary.javageeks.examples.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipes {
    public static void main(String[] args) throws IOException {
        Source source = new Source();
        Target target = new Target(source.getStream());
        source.start();
        target.start();
    }
}

class Target extends Thread {
    private PipedReader pr;

    Target(PipedWriter pw) throws IOException {
        pr = new PipedReader(pw);
    }

    PipedReader getStream() {
        return pr;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Reading: " + pr.read());
            } catch (Exception e) {
                System.out.println("The job's finished.");
                System.exit(0);
            }
        }
    }

}

class Source extends Thread {
    private PipedWriter pw = new PipedWriter();

    PipedWriter getStream() {
        return pw;
    }

    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
                pw.write(k);
                System.out.println("Writing: " + k);
            } catch (Exception e) {
                System.err.println("From Source.run(): " + e);
            }
        }
    }
}
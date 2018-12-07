package com.hillel.elementary.javageeks.examples.threads.synchronize;

public class Body {
    public long idNum;
    public String nameFor;
    public Body orbits;

    private static long nextID = 0;

    Body() {
        synchronized (Body.class) {
            idNum = nextID++;
        }
    }
}

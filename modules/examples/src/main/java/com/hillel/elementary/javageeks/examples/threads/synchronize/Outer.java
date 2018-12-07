package com.hillel.elementary.javageeks.examples.threads.synchronize;

public class Outer {
    private int data;

    private class Inner {
        void setOuterData() {
            synchronized (Outer.this) {
                data = 12;
            }
        }

    }
}

package com.hillel.elementary.javageeks.examples.threads.synchronize;

public class SeparateGroups {
    private double aval = 0.0;
    private double bval = 1.1;
    protected Object lockA = new Object();
    protected Object lockB = new Object();

    public double getA() {
        synchronized (lockA) {
            return aval;
        }
    }

    public void setA(double val) {
        synchronized (lockA) {
            aval = val;
        }
    }

    public double getB() {
        synchronized (lockB) {
            return bval;
        }
    }

    public void setB(double val) {
        synchronized (lockB) {
            bval = val;
        }
    }

    public void reset() {
        synchronized (lockA) {
            synchronized (lockB) {
                aval = bval = 0.0;
            }
        }
    }
}

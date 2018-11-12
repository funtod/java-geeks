package com.hillel.elementary.javageeks.examples.patterns;

public class Singleton {

    private Singleton() { }

    private static class InstanceHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}

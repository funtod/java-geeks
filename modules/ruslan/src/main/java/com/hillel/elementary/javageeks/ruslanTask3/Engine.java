package com.hillel.elementary.javageeks.ruslanTask3;

public class Engine {

    int count;
    String type;

    public Engine(int count, String type) {
        this.count = count;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return " TeslaModel_5 [count=" + count + ", type=" + type + "]";
    }


}

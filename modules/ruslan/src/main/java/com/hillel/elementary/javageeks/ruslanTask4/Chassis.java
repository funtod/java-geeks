package com.hillel.elementary.javageeks.ruslanTask4;

public class Chassis {
    int count;
    String typeChassis;
    public Chassis(int count, String typeChassis) {
        this.count = count;
        this.typeChassis = typeChassis;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getTypeChassis() {
        return typeChassis;
    }
    public void setTypeChassis(String typeChassis) {
        this.typeChassis = typeChassis;
    }
    @Override
    public String toString() {
        return "Chevrolet [count=" + count + ", typeChassis=" + typeChassis + "]";
    }
}
package com.hillel.elementary.javageeks.artem;
public class Engine{
    private int power;
    private String name;
    public Engine(int power, String name) {
        this.power = power;
        this.name = name;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "  power="+this.power+", name="+this.name;
    }
}
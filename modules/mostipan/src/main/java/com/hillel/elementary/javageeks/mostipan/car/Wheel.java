package com.hillel.elementary.javageeks.mostipan.car;

public class Wheel {
    private int amounntWheels;
    public int getAmounntWheels() {
        return amounntWheels;
    }

    public void setAmounntWheels(int amounntWheels) {
        this.amounntWheels = amounntWheels;
    }

    public Wheel(int amounntWheels) {
        this.amounntWheels = amounntWheels;
    }

    public void changeWheel(){

        System.out.print("You chenged wheel");

    }


}

package com.hillel.elementary.javageeks.mostipan.car;

public class Wheels {
    private int amounntWheels;

    public int getAmounntWheels() {
        return amounntWheels;
    }

    public void setAmounntWheels(int amounntWheels) {
        this.amounntWheels = amounntWheels;
    }

    public Wheels(int amounntWheels) {
        this.amounntWheels = amounntWheels;
    }

    public void changeWheel() {

        System.out.print("You chenged wheels");

    }

    public boolean isWheelsEnough() {
        if (getAmounntWheels() < 4) {
            return false;
        }
        else return true;
    }
}


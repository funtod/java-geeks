package com.hillel.elementary.javageeks.mostipan.car;

public class Engine {
    private double volumeEngine;
private  boolean engineIsWorking;
    public double getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(double volumeEngine) {
        this.volumeEngine = volumeEngine;
    }
    public Engine(double volumeEngine){
        this.volumeEngine=volumeEngine;
    }

    public boolean isEngineWorking() {
        return engineIsWorking;
    }

    public void setEngineIsWorking(boolean engineIsWorking) {
        this.engineIsWorking = engineIsWorking;
    }
}

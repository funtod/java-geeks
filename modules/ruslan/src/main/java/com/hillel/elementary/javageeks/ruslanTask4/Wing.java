package com.hillel.elementary.javageeks.ruslanTask4;

public class Wing {
    String typeOfWing;
    String manufacture;
    Engine engine;

    public Wing(String typeOfWing, String manufacture, Engine engine) {
        this.typeOfWing = typeOfWing;
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public Wing(String typeOfWing, String manufacture) {
        this.typeOfWing = typeOfWing;
        this.manufacture = manufacture;
    }

    public Wing() {

    }

    public String getTypeOfWing() {
        return typeOfWing;
    }

    public void setTypeOfWing(String typeOfWing) {
        this.typeOfWing = typeOfWing;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Wing [typeOfWing=" + typeOfWing + ", manufacture=" + manufacture + ", engine=" + engine + "]";
    }


}
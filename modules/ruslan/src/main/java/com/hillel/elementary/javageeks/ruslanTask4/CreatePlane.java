package com.hillel.elementary.javageeks.ruslanTask4;


public class CreatePlane {

    public static void main(String[] args) {
        Chassis chassis = new Chassis(2, "wheel");
        Engine engine = new Engine(1, "internal combustion");
        Engine engine2 = new Engine(1,"internal combustion");
        Wing wingR = new Wing("Right", "Aircraft",engine2);
        Wing wingL = new Wing("Left", "AircraftSunCorp");
        wingL.setEngine(new Engine(1,"Electro"));

        Plane planeAerobus = new Plane("none", "A380", "none", chassis, engine, wingR, wingL);
        planeAerobus.setWingL(wingL);
        planeAerobus.setFly("The plane flies");
        planeAerobus.getFly();
        planeAerobus.setRoute("Kiev-Tivat");
        planeAerobus.getRoute();
        System.out.println(planeAerobus);
    }
}
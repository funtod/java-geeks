package com.hillel.elementary.javageeks.ruslanTask4;


public class CreatePlane {

    public static void main(String[] args) {

        Chassis chassis = new Chassis(2, "wheel");
        Engine engine = new Engine(1, "internal combustion");
        Wing wing = new Wing("long and bright", "aircraft");

        Plane planeAerobus = new Plane("none", "A380", "none", chassis, engine, wing);

        planeAerobus.setFly("The plane flies");
        planeAerobus.getFly();
        planeAerobus.setRoute("Kiev-Tivat");
        planeAerobus.getRoute();

        System.out.println(planeAerobus);


    }

}
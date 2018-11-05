package com.hillel.elementary.javageeks.ruslanTask3;

public class Plane {

    String fly;
    String name;
    String route;
    Chassis chassis;
    Engine engine;
    Wing wing;

    public Plane(String fly, String name, String route, Chassis chassis, Engine engine, Wing wing) {
        this.fly = fly;
        this.name = name;
        this.route = route;
        this.chassis = chassis;
        this.engine = engine;
        this.wing = wing;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getFly() {
        System.out.println("Fly : " + this.fly);
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    public void getRoute() {
        System.out.println("Route : " + this.route);
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    @Override
    public String toString() {
        return "Plane name=" + name +"\nchassis = " + chassis + "\nengine =" + engine + "\nwing ="
                + wing;
    }



}

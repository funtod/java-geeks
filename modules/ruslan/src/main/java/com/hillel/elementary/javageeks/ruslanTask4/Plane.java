package com.hillel.elementary.javageeks.ruslanTask4;


public class Plane {

    String fly;
    String name;
    String route;
    Chassis chassis;
    Engine engine;
    Wing wingR;
    Wing wingL;

    public Plane(String fly, String name, String route, Chassis chassis, Engine engine, Wing wingR, Wing wingL) {
        this.fly = fly;
        this.name = name;
        this.route = route;
        this.chassis = chassis;
        this.engine = engine;
        this.wingL = wingL;
        this.wingR = wingR;
    }
    public String getName() {
        return name;
    }
    public Wing getWingR() {
        return wingR;
    }
    public void setWingR(Wing wingR) {
        this.wingR = wingR;
    }
    public Wing getWingL() {
        return wingL;
    }
    public void setWingL(Wing wingL) {
        this.wingL = wingL;
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
    @Override
    public String toString() {
        return "Plane [name=" + name + ", chassis=" + chassis + ", engine="
                + engine + ", wingR=" + wingR + ", wingL=" + wingL + "]";
    }

}
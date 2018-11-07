package com.hillel.elementary.javageeks.artem;

public class Plane {
    String route;
    String name;
    Wing wing;
    Chassis chassis;
    Engine engine;
    public Plane(String name, Wing wing, Chassis chassis, Engine engine) {
        this.route = route;
        this.name = name;
        this.wing = wing;
        this.chassis = chassis;
        this.engine = engine;
    }
    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public String fly(){
        if (getRoute()==null){
            return "Flight is impossible(the plane has not a rount)";
        }else {
            return toString();
        }
    }
    @Override
    public String toString() {
        return "The plane is flying." +
                "\nPlane:   route='" + route + '\'' +
                ", name='" + name + '\'' +
                "\nWing:" + wing +
                ",\nChassis:" + chassis +
                ",\nEngine:" + engine;
    }
}
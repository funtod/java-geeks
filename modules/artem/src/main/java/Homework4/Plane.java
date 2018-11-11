package Homework4;

public class Plane {
    String route;
    String name;
    Wings wing;
    Chassis chassis;
    Engine engine;

    public Plane(String route, String name, Wings wing, Chassis chassis, Engine engine) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wings getWing() {
        return wing;
    }

    public void setWing(Wings wing) {
        this.wing = wing;
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
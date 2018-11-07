package com.hillel.elementary.javageeks.artem;
import org.junit.jupiter.api.Test;

class PlaneTest {
    @Test
    public void test(){
        Wing wing = new Wing(2,"WiNgS");
        Chassis chassis = new Chassis(8);
        Engine engine = new Engine(1200,"EnGiNe");
        Plane plane = new Plane("A1234",wing,chassis,engine);
        plane.setRoute("Kyiv-London");
        System.out.println(plane.fly());

    }
}
package com.hillel.elementary.javageeks.ruslanTask4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class PlaneTest {

    Plane plane;
    Chassis chassis;
    Engine engine;
    Wing wingR;
    Wing wingL;

    @BeforeAll
    public void setPrepareDetails() {
        plane = new Plane();
        chassis = new Chassis(2, "wheel");
        engine = new Engine(1, "internal combustion");
        wingR = new Wing("Right", "Aircraft",engine);
        wingL = new Wing("Left", "AircraftSunCorp");
        plane.setEngine(engine);
        plane.setChassis(chassis);
        plane.setWingR(wingR);
        plane.setWingL(wingL);
        plane.setName("A380");

    }

    @Test
    public void checkEngine() {

      assertThat(plane.getEngine().getType()).isEqualTo("internal combustion");
    }

    @Test
    public void checkChassis() {

        assertThat(plane.getChassis().getTypeChassis()).isEqualTo("wheel");
        assertThat(plane.getChassis().getCount()).isEqualTo(2);
    }

    @Test
    public void checkWings() {

        assertThat(plane.getWingR().getTypeOfWing()).isEqualTo("Right");
        assertThat(plane.getWingL().getTypeOfWing()).isEqualTo("Left");
    }

    @Test
    public void checkPlaneName() {

        assertThat(plane.getName()).isEqualTo("A380");
    }

    @Test
    public void checkPlaneRoute() {

        plane.setRoute("Kiev-Tivat");
        plane.getRoute();

        assertThat(plane.getRoute()).isEqualTo("Kiev-Tivat");
    }

    @Test
    public void checkPlaneFly() {

        plane.setFly("The plane flies");
        plane.getFly();

        assertThat(plane.getFly()).isEqualTo("The plane flies");
    }

}
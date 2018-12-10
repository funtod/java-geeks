package com.hillel.elementary.javageeks.ruslanTask4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ChassisTest {

    public Chassis chassis;

    @BeforeAll
    public void shouldGetChassis() {
        chassis = new Chassis ( 2 , "wheel");
    }

    @Test
    public void ShouldPrintChassisModel() {
        assertThat(chassis.getTypeChassis()).isEqualTo("wheel");
    }

    @Test
    public void ShouldPrintChassisCount() {
        assertThat(chassis.getCount()).isEqualTo(2);
    }

}
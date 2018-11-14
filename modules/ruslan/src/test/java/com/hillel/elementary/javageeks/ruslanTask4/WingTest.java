package com.hillel.elementary.javageeks.ruslanTask4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class WingTest {

    public Wing wing;

    @BeforeAll
    public void shouldGetWing() {
        wing = new Wing ("long and bright", "aircraft");
    }

    @Test
    public void ShouldPrintWingModel() {
        assertThat(wing.getTypeOfWing()).isEqualTo("long and bright");
    }

    @Test
    public void ShouldPrintWingManufacturer() {
        assertThat(wing.getManufacture()).isEqualTo("aircraft");
    }

}
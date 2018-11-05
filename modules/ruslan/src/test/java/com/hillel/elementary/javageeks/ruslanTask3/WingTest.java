package com.hillel.elementary.javageeks.ruslanTask3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class WingTest {

    public Wing  wing;

    @BeforeAll
    public void shouldGetWing() {
        wing = new Wing (4, "long and bright", "aircraft");
    }

    @Test
    public void ShouldPrintWingModel() {
        assertThat(wing.getName()).isEqualTo("long and bright");
    }

    @Test
    public void ShouldPrintWingCount() {
        assertThat(wing.getCount()).isEqualTo(4);
    }

    @Test
    public void ShouldPrintWingManufacturer() {
        assertThat(wing.getManufacturer()).isEqualTo("aircraft");
    }

}

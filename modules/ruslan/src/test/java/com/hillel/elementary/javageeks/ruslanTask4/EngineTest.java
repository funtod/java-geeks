package com.hillel.elementary.javageeks.ruslanTask4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class EngineTest {

    public Engine engine;

    @BeforeAll
    public void shouldGetEngine() {
        engine = new Engine ( 1 , "internal combustion");
    }

    @Test
    public void ShouldPrintEngineModel() {
        assertThat(engine.getType()).isEqualTo("internal combustion");
    }

    @Test
    public void ShouldPrintEngineCount() {
        assertThat(engine.getCount()).isEqualTo(1);
    }

}
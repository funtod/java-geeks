package com.hillel.elementary.javageeks.mostipan.car;

import com.hillel.elementary.javageeks.mostipan.car.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CarTest {
    public Car lada;

    @BeforeAll
    public void initialiseNewCar() {
        lada = new Car("Lada", 10, 100, new Wheel(4), new Engine(2.0));

    }

    @Test
    public void ShouldPrintCarModel() {
        assertThat(lada.getModel()).isEqualTo("Lada");
    }


    @Test
    public void shouldCarMove() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        lada.engine.setEngineIsWorking(true);
        lada.move();
        assertThat(new String(out.toByteArray())).isEqualTo("Car is moves");
    }

    @Test
    public void shouldChengeWheel() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        lada.wheel.changeWheel();
        assertThat(new String(out.toByteArray())).isEqualTo("You chenged wheel");
    }

    @Test
    public void shouldFillTheTank() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        lada.fillTheTank(10);
        assertThat(new String(out.toByteArray())).isEqualTo("You filled up the tank:" + 10);
    }
    @Test
    public void shouldEngineisBroken() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        lada.engine.setEngineIsWorking(false);
        lada.move();
        assertThat(new String(out.toByteArray())).isEqualTo("Engine is broken!");
    }



}


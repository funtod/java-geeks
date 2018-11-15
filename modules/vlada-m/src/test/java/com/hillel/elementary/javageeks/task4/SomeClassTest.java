package com.hillel.elementary.javageeks.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    void shouldEatApples() throws Exception {
        int applesToEat = 105;
        int numberOfAttempts = 2;

        assertThrows(Exception.class, () -> SomeClass.eatApples(applesToEat, numberOfAttempts));
    }
}
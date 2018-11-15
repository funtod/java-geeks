package com.hillel.elementary.javageeks.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTestWithoutException {

    @Test
    void shouldEatApples() throws Exception {
        int applesToEat = 5;
        int numberOfAttempts = 2;

        SomeClass.eatApples(applesToEat, numberOfAttempts);
        assertEquals(90, SomeClass.eatApples(applesToEat, numberOfAttempts));
    }
}
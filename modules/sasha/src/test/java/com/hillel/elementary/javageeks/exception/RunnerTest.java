package com.hillel.elementary.javageeks.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    @Test
    void shouldGiveArithmeticException(){


        assertThrows(LowerException.class, () -> Runner.run());
    }

}
package com.hillel.elementary.javageeks.custom_exception;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SomeClassTest {

    SomeClass someClass = new SomeClass();
    SomeClass.SpecificException specificException;

    @Test
    void shouldThrowException() {
        try {
            someClass.second();
        } catch (SomeClass.SpecificException e) {
            specificException = e;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        assertThat(specificException.getMessage()).isEqualTo("Some definite reasons cause an exception");
    }
}
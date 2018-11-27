package com.hillel.elementary.javageeks.task4;

import org.junit.jupiter.api.Test;

import java.util.IllegalFormatConversionException;

import static org.junit.jupiter.api.Assertions.*;

class ConverterWithExceptionTest {

    @Test
    void shouldReturnNaN() {
            String text = "Name";
            double number = Converter.convert(text);
            boolean isNaN = Double.isNaN(number);
            assertTrue(isNaN);

    }
}
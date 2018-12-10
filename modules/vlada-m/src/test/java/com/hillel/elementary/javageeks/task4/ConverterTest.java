package com.hillel.elementary.javageeks.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void shouldConvertWithoutException() {
        String text = "15.76";
        double stringToDouble = Converter.convert(text);
        boolean isNaN = Double.isNaN(stringToDouble);
        assertFalse(isNaN);

    }
}
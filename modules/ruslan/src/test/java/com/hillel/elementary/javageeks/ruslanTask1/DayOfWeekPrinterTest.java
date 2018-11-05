package com.hillel.elementary.javageeks.ruslanTask1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DayOfWeekPrinterTest {

    private DayOfWeekPrinter dayOfWeekPrinter = new DayOfWeekPrinter();

    @Test
    public void shouldReadNumberFromOnetoSeven () {

    //given
        String input = "5";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

    //when

        dayOfWeekPrinter.printDayOfWeek();

    //then
        assertThat(new String(out.toByteArray())).contains("Thursday");
    }
}


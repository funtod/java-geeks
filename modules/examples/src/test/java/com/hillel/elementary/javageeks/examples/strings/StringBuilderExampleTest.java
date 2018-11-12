package com.hillel.elementary.javageeks.examples.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderExampleTest {

    @Test
    void shouldReturnCorrectValues() {
        StringBuilder stringBuffer = new StringBuilder();

        assertEquals(0, stringBuffer.length());

        assertEquals(16, stringBuffer.capacity()); // 16 - значение размера массива по умолчанию

        //stringBuffer = "Java"; //ошибка, только для класса String
        stringBuffer.append("Java");
        stringBuffer.append(" is");
        stringBuffer.append(" something"); //increasing capacity. @see AbstractStringBuilder.newCapacity
        stringBuffer.append(" anyone");
        stringBuffer.append(" can");
        stringBuffer.append(" learn!");

        assertEquals("Java is something anyone can learn!", stringBuffer.toString());
        assertEquals(35, stringBuffer.length());
        assertEquals(70, stringBuffer.capacity());
        assertEquals("!nrael nac enoyna gnihtemos si avaJ", stringBuffer.reverse().toString());
    }

}
package com.hillel.elementary.javageeks.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void shouldBeSummingMethod() {
        //given
        int firstInteger = 45;
        int secondInteger = 15;
        //when
        int sum = Main.summingMethod(firstInteger, secondInteger);

        //then
        assertEquals(60, sum);
    }

    @Test
    void shouldBeDifferenceMethod() {
        //given
        int firstInteger = 45;
        int secondInteger = 15;
        int difference = Main.differenceMethod(firstInteger, secondInteger);
        assertEquals(30, difference);
    }

    @Test
    void productMethod() {
        //given
        int firstInteger = 45;
        int secondInteger = 15;

        //when
        int product = Main.productMethod(firstInteger, secondInteger);

        //then
        assertEquals(675, product);
    }

    @Test
    void averageMethod() {
        //given
        int firstInteger = 45;
        int secondInteger = 15;
        //when
        int average = Main.averageMethod(firstInteger, secondInteger);

        //then
        assertEquals(30, average);
    }
}
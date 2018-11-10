package com.hillel.elementary.javageeks.examples.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SplitTest {
    @Test
    void shouldTrimAndSplit() {

        String[] expectedResult = {"albina", "Alena", "Alice", "alina", "ALLA", "Anastasya", "ArinA"};

        String[] result = Split.getSortedNames(" Alena Alice alina albina Anastasya ALLA ArinA ");

        assertThat(expectedResult).isEqualTo(result);
    }
}
package com.hillel.elementary.javageeks.examples.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SubstringExampleTest {

    @Test
    void shouldReturnLastFourChars() {

        assertThat(SubstringExample.getLastFourChars("123456789")).isEqualTo("6789");
    }


    @Test
    void shouldReplace() {
        assertThat("Valalala".replace("a", "B")).isEqualTo("VBlBlBlB");
    }


    @Test
    void shouldTrim() {
        assertThat("   Valalala   ".trim()).isEqualTo("Valalala");
    }

    @Test
    void shouldFormat() {
        System.out.println(Arrays.toString("Valalala".split("a")));

        String text = String.format("This is my %d message, And %d", 3, 4040);

        assertThat("   Valalala   ".trim()).isEqualTo("Valalala");
    }
}
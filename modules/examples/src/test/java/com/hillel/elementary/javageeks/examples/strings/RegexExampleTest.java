package com.hillel.elementary.javageeks.examples.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegexExampleTest {

    @Test
    void shouldReturnTrueIfVasyaIsPresent() {
        String text = "This is definetely not Vasyaabcabc";

        assertThat(RegexExample.hasVasya(text)).isTrue();
    }
}
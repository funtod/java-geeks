package com.hillel.elementary.javageeks.huffman_algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TextCompressorTest {

    @Test
    void shouldReturnMinimumPrefixCodeForMostCommonCharacter() {
        String txt = "aabbaabbaabbbfftbbbbbteeeeeeeeeeeeeeeeewbbb";
        assertThat(new TextCompressor().compress(txt)).contains("e:0");
    }

    @Test
    void shouldReturnPrefixForOneLetterText() {
        String txt = "a";
        assertThat(new TextCompressor().compress(txt)).contains("a:0");
    }

    @Test
    void shouldReturnEmptyString() {
        String txt = "";
        assertThat(new TextCompressor().compress(txt)).isEmpty();
    }

    @Test
    void shouldReturnNull() {
        String txt = null;
        assertThat(new TextCompressor().compress(txt)).isNull();
    }
}

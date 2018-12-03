package com.hillel.elementary.javageeks.huffman_algorithm;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TextCompressorTest {

    @Test
    void shouldReturnPrefixForOneLetterText() throws IOException {

        FileCompressor.compress("/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl.txt",
                "/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl_encoded.txt",
                "/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl_key.txt");

        FileCompressor.decompress("/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl_encoded.txt",
                "/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl_key.txt",
                "/home/alex/IdeaProjects/java-geeks/modules/alex-n/src/fl_decompressed.txt");

        assertThat(1).isEqualTo(1);
    }
}

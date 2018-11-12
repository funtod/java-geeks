package com.hillel.elementary.javageeks.examples.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

class BufferedReaderExampleTest {

    @Test
    void shouldRunBufferedReader() {
        byte[] input = "abcdeq\nand a full line here\nanother full line\nq".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BufferedReaderExample.run(inputStream, outputStream);

        assertThat("PrintWriter puts: Hello, World\n" +
                "Character input:\na\nb\nc\nd\ne\n" +
                "Line input:\n\n" +
                "and a full line here\n" +
                "another full line\n").isEqualToIgnoringNewLines(outputStream.toString());
    }
}
package com.hillel.elementary.javageeks.examples.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class FileCopyExampleTest {

    @Test
    void shouldCopyAFile() throws IOException, URISyntaxException {
        URL resource = FileCopyExampleTest.class.getClassLoader().getResource("pride_and_prejudice.txt");
        String fileFrom = resource.getFile();
        String fileTo = File.createTempFile("pride_and_prejudice", ".txt").getAbsolutePath();

        FileCopyExample.copy(fileFrom, fileTo);

        String expected = new String(Files.readAllBytes(Paths.get(resource.toURI())));
        String actual =  new String(Files.readAllBytes(Paths.get(fileTo)));
        assertThat(actual).isEqualTo(expected);
    }
}
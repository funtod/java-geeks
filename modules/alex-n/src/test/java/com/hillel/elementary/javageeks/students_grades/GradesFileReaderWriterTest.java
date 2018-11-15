package com.hillel.elementary.javageeks.students_grades;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Java6Assertions.assertThat;

class GradesFileReaderWriterTest {

    @Test
    void shouldWriteAndReadFile() throws IOException {
        String str = "Ivanov - 1\n" +
                     "Petrov - 2";
        Path path = null;
        path = Files.createTempFile("tmpGrades",null);
        GradesFileReaderWriter.writeToFile(path.toString(), str);
        assertThat(GradesFileReaderWriter.readFromFile(path.toString())).isEqualTo(str);
    }

    @Test
    void shouldOutputMessageIfPathIsNull() {
        String str = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        GradesFileReaderWriter.writeToFile(null, str);
        assertThat(new String(out.toByteArray())).isEqualTo("Invalid path to file or string");
    }

    @Test
    void shouldOutputMessageIfStringIsNull() throws IOException {
        Path path = null;
        path = Files.createTempFile("tmpGrades",null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        GradesFileReaderWriter.writeToFile(path.toString(), null);
        assertThat(new String(out.toByteArray())).isEqualTo("Invalid path to file or string");
    }
}
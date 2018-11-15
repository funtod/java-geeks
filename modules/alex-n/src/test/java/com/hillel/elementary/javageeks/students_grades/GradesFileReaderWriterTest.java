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
    void shouldWriteAndReadFile() {
        String str = "Ivanov - 1\n" +
                     "Petrov - 2";
        Path path = null;
        try {
            path = Files.createTempFile("tmpGrades",null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GradesFileReaderWriter.WriteGradesToFile(path.toString(), str);
        assertThat(GradesFileReaderWriter.ReadGradesFromFile(path.toString())).isEqualTo(str);
    }

    @Test
    void shouldOutputMessageIfPathIsNull() {
        String str = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        GradesFileReaderWriter.WriteGradesToFile(null, str);
        assertThat(new String(out.toByteArray())).isEqualTo("Invalid path to file or string");
    }

    @Test
    void shouldOutputMessageIfStringIsNull() {
        Path path = null;
        try {
            path = Files.createTempFile("tmpGrades",null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        GradesFileReaderWriter.WriteGradesToFile(path.toString(), null);
        assertThat(new String(out.toByteArray())).isEqualTo("Invalid path to file or string");
    }
}
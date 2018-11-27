package com.hillel.elementary.javageeks.students_grades;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StudentMarkerTest {

    @Test
    void shouldMarkStudentsWithAverageGradeMoreThan() throws IOException {
        String input = "Ivanov - 2\n" +
                       "Ivanov - 4\n" +
                       "Petrov - 3\n" +
                       "Sidorov - 6\n" +
                       "Sidorov - 8";
        String expected = "Ivanov - 2\n" +
                          "Ivanov - 4\n" +
                          "Petrov - 3\n" +
                          "SIDOROV - 6\n" +
                          "SIDOROV - 8";
        Path path = null;
        path = Files.createTempFile("tmpGrades",null);
        GradesFileReaderWriter.writeToFile(path.toString(), input);
        StudentMarker.markStudentsInFile(path.toString(), 6);
        assertThat(GradesFileReaderWriter.readFromFile(path.toString())).isEqualTo(expected);
    }
}
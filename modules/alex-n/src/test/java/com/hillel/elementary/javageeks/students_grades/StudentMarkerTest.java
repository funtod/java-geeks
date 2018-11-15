package com.hillel.elementary.javageeks.students_grades;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StudentMarkerTest {

    @Test
    void shouldMarkStudentsWithAverageGradeMoreThan() {
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
        try {
            path = Files.createTempFile("tmpGrades",null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GradesFileReaderWriter.WriteGradesToFile(path.toString(), input);
        StudentMarker.MarkStudentsInFile(path.toString(), 6);
        assertThat(GradesFileReaderWriter.ReadGradesFromFile(path.toString())).isEqualTo(expected);
    }
}
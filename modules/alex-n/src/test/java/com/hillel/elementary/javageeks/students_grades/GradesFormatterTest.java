package com.hillel.elementary.javageeks.students_grades;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class GradesFormatterTest {

    GradesFormatter gradesFormatter = new GradesFormatter();

    @Test
    void shouldReturnEmptyString() {
        String text = "";
        assertThat(gradesFormatter.highlightSurnameIfAverageGradeIsMoreThan(text, 2)).isEqualTo("");
    }

    @Test
    void shouldReturnNull() {
        String text = null;
        assertThat(gradesFormatter.highlightSurnameIfAverageGradeIsMoreThan(text, 2)).isNull();
    }

    @Test
    void shouldReformatString() {
        String input = "Ivanov - 2\n" +
                       "Petrov - 3\n" +
                       "Sidorov - 8";
        String expected = "Ivanov - 2\n" +
                          "Petrov - 3\n" +
                          "SIDOROV - 8";
        assertThat(gradesFormatter.highlightSurnameIfAverageGradeIsMoreThan(input, 7)).isEqualTo(expected);
    }

    @Test
    void shouldReformatStringWithMultiplySurnames() {
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
        assertThat(gradesFormatter.highlightSurnameIfAverageGradeIsMoreThan(input, 6)).isEqualTo(expected);
    }
}
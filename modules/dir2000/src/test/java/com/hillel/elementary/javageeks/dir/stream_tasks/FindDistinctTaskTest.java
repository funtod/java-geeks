package com.hillel.elementary.javageeks.dir.stream_tasks;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class FindDistinctTaskTest {
    private List<String> emptyTagsList = Collections.emptyList();
    private LocalDate dummyDate = LocalDate.of(2018, 12, 1);


    @Test
    void shouldReturnDistinctListOfTasks() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 1", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 1", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 7", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 8", TaskType.SPEAKING, dummyDate, emptyTagsList),
                new Task("Lesson 7", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 8", TaskType.SPEAKING, dummyDate, emptyTagsList),
                new Task("Lesson 9", TaskType.READING, dummyDate, emptyTagsList)
        );

        List<Task> result = FindDistinctTask.allDistinctTasks(tasks);

        assertThat(result).isEqualTo(Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 7", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 8", TaskType.SPEAKING, dummyDate, emptyTagsList),
                new Task("Lesson 9", TaskType.READING, dummyDate, emptyTagsList)
        ));
    }

    @Test
    void shouldReturnListOfReadingTaskNames() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, LocalDate.of(2018, 1, 1), emptyTagsList),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 3", TaskType.READING, LocalDate.of(2018, 10, 1), emptyTagsList),
                new Task("Lesson 4", TaskType.SPEAKING, dummyDate, emptyTagsList),
                new Task("Lesson 5", TaskType.READING, LocalDate.of(2017, 7, 1), emptyTagsList),
                new Task("Lesson 6", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 7", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 8", TaskType.SPEAKING, dummyDate, emptyTagsList),
                new Task("Lesson 9", TaskType.READING, LocalDate.of(2017, 1, 1), emptyTagsList),
                new Task("Lesson 10", TaskType.READING, LocalDate.of(2018, 10, 1), emptyTagsList),
                new Task("Lesson 11", TaskType.READING, LocalDate.of(2018, 11, 1), emptyTagsList),
                new Task("Lesson 12", TaskType.READING, LocalDate.of(2018, 12, 1), emptyTagsList)
        );

        List<String> result = FindDistinctTask.top5ReadingTaskNames(tasks);

        assertThat(result).isEqualTo(Arrays.asList(
                "Lesson 9",
                "Lesson 5",
                "Lesson 1",
                "Lesson 3",
                "Lesson 10"
        ));
    }

    @Test
    void shouldReturnCorrectNumberOfTasksByType() {
        LocalDate creationDate = LocalDate.of(2018, 1, 1);
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, LocalDate.of(2018, 1, 1), emptyTagsList),
                new Task("Lesson 2", TaskType.WRITING, creationDate, emptyTagsList),
                new Task("Lesson 3", TaskType.READING, LocalDate.of(2018, 10, 1), emptyTagsList),
                new Task("Lesson 4", TaskType.SPEAKING, creationDate, emptyTagsList),
                new Task("Lesson 5", TaskType.READING, LocalDate.of(2017, 7, 1), emptyTagsList),
                new Task("Lesson 6", TaskType.WRITING, creationDate, emptyTagsList),
                new Task("Lesson 7", TaskType.WRITING, creationDate, emptyTagsList),
                new Task("Lesson 8", TaskType.SPEAKING, creationDate, emptyTagsList),
                new Task("Lesson 9", TaskType.READING, LocalDate.of(2017, 1, 1), emptyTagsList),
                new Task("Lesson 10", TaskType.READING, LocalDate.of(2018, 10, 1), emptyTagsList),
                new Task("Lesson 11", TaskType.READING, LocalDate.of(2018, 11, 1), emptyTagsList),
                new Task("Lesson 12", TaskType.READING, LocalDate.of(2018, 12, 1), emptyTagsList)
        );

        Long result = FindDistinctTask.countAllTasksByType(tasks, TaskType.READING);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldReturnDistinctListOfTaskTags() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, Arrays.asList("English", "Grammar", "Books")),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, Arrays.asList("Spanish", "Grammar")),
                new Task("Lesson 3", TaskType.READING, dummyDate, Arrays.asList("History", "Rome")),
                new Task("Lesson 4", TaskType.SPEAKING, dummyDate, Arrays.asList("English", "Grammar"))
        );

        List<String> result = FindDistinctTask.getAllDistinctTags(tasks);
        assertThat(result).isEqualTo(Arrays.asList(
                "English",
                "Grammar",
                "Books",
                "Spanish",
                "History",
                "Rome"
        ));
    }

    @Test
    void shouldReturnTrueIfAllReadingTasksHaveBooksTag() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, Arrays.asList("English", "Grammar", "Books")),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, Arrays.asList("Spanish", "Grammar")),
                new Task("Lesson 3", TaskType.READING, dummyDate, Arrays.asList("History", "Rome", "Books")),
                new Task("Lesson 4", TaskType.SPEAKING, dummyDate, Arrays.asList("English", "Grammar"))
        );

        Boolean result = FindDistinctTask.isAllReadingTasksWithTagBooks(tasks);
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseIfNotAllReadingTasksHaveBooksTag() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, Arrays.asList("English", "Grammar", "Books")),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, Arrays.asList("Spanish", "Grammar")),
                new Task("Lesson 3", TaskType.READING, dummyDate, Arrays.asList("History", "Rome")),
                new Task("Lesson 4", TaskType.SPEAKING, dummyDate, Arrays.asList("English", "Grammar"))
        );

        Boolean result = FindDistinctTask.isAllReadingTasksWithTagBooks(tasks);
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnASummaryOfAllTaskTitles() {
        List<Task> tasks = Arrays.asList(
                new Task("Lesson 1", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 2", TaskType.WRITING, dummyDate, emptyTagsList),
                new Task("Lesson 3", TaskType.READING, dummyDate, emptyTagsList),
                new Task("Lesson 4", TaskType.SPEAKING, dummyDate, emptyTagsList)
        );

        String result = FindDistinctTask.joinAllTaskTitles(tasks);
        assertThat(result).isEqualTo("Lesson 1***Lesson 2***Lesson 3***Lesson 4");
    }


    @Test
    void shouldReturnListWithPrefixes() {
        String expected = "o1,o5,o7,e8,e100,o1001";

        String result = FindDistinctTask.evensAndOdds("1, 5,    7,8,100,1001");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnEmptyStringIfNothingIsPassed() {
        String expected = "";

        String result = FindDistinctTask.evensAndOdds("");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnListWithOnly3LetterWordsStartingWithA() {
        List<String> expected = Lists.list("abc", "aaa");

        List<String> result = FindDistinctTask.searchForThreeLetterWordsStartingWithA(Lists.list("abc", "bbb", "ab", "abcd", "", "aaa"));

        assertThat(result).isEqualTo(expected);
    }

}
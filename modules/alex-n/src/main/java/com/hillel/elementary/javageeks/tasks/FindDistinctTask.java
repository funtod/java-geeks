package com.hillel.elementary.javageeks.tasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindDistinctTask {

    // Вернуть список с уникальными задачами (доп. сложность - с уникальными именами)
    public static List<Task> allDistinctTasks(List<Task> tasks) {
        return tasks.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Найти 5 первых (по дате создания) задач по чтению, вернуть имя задачи
    public static List<String> top5ReadingTaskNames(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted(Comparator.comparing(Task::getCreationDate))
                .map(Task::getName)
                .limit(5)
                .collect(Collectors.toList());
    }

    // Посчитать количество задач указанного типа
    public static Long countAllTasksByType(List<Task> tasks, TaskType type) {
        return (long) tasks.stream()
                .filter(task -> task.getType() == type)
                .collect(Collectors.toList())
                .size();
    }

    // Вернуть все уникальные теги задач
    public static List<String> getAllDistinctTags(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getTags)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    // Проверить у всех ли задач по чтению есть тег "Books"
    public static Boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        return tasks.stream()
                .allMatch(task -> task.getTags().contains("Books"));
    }

    //Сконкатенировать все названия задач в одну надпись через "***"
    public static String joinAllTaskTitles(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getName)
                .reduce((s1, s2) -> s1 + "***"+ s2).get();
    }

    // Вернуть строку с числами, перечисленными через запятую на основе заданного списка целых чисел.
    // Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
    // Например, если список ввода (3,44), вывод должен быть 'o3, e44'.
    public static String evensAndOdds(String numbers) {
            return Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .map(integer -> (integer % 2 == 0 ? "e" + integer : "o" + integer))
                    .reduce((s1, s2) -> s1 + "," + s2)
                    .orElse("");
    }

    //Вернуть список всех строк, которые начинаются с буквы «а» и имеют ровно 3 буквы
    public static List<String> searchForThreeLetterWordsStartingWithA(List<String> list) {
        return list.stream()
                .filter(str -> str.length() == 3)
                .filter(str -> str.indexOf("a") == 0)
                .collect(Collectors.toList());
    }

}

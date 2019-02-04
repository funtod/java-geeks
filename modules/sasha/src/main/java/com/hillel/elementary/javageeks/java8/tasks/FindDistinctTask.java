package com.hillel.elementary.javageeks.java8.tasks;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindDistinctTask {

    // Вернуть список с уникальными задачами (доп. сложность - с уникальными именами)
    public static List<Task> allDistinctTasks(List<Task> tasks) {
        List<Task>taskList = tasks.stream()
                .distinct()
                .collect(Collectors.toList());

        return taskList;
    }

    // Найти 5 первых (по дате создания) задач по чтению, вернуть имя задачи
    public static List<String> top5ReadingTaskNames(List<Task> tasks) {
        List<String>stringList = tasks.stream()
                .filter(task -> task.getType().equals(TaskType.READING))
                .sorted((s1,s2)->s1.getCreationDate().compareTo(s2.getCreationDate()))
                .map(task -> task.getName())
                .limit(5)
                .collect(Collectors.toList());
        return stringList;


    }



    // Посчитать количество задач указанного типа
    public static Long countAllTasksByType(List<Task> tasks, TaskType type) {
        Long longA = tasks.stream()
                .map(task -> task.getType())
                .filter(TaskType-> TaskType.equals(type))
                .count();
        return longA;
    }

    // Вернуть все уникальные теги задач
    public static List<String> getAllDistinctTags(List<Task> tasks) {
        List<String>stringList = tasks.stream()
                .flatMap( task -> task.getTags().stream())
                .distinct()
                .collect(Collectors.toList());

        return stringList;
    }

    // Проверить у всех ли задач по чтению есть тег "Books"
    public static Boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.getType().equals(TaskType.READING))
                .allMatch(task ->task.getTags().contains("Books"));
    }

    //Сконкатенировать все названия задач в одну надпись через "***"
    public static String joinAllTaskTitles(List<Task> tasks) {
        Optional<String>stringOptional = tasks.stream()
                .map(task -> task.getName())
                .reduce((s1,s2)-> s1 + "***" + s2);
        return stringOptional.get();
    }

    // Вернуть строку с числами, перечисленными через запятую на основе заданного списка целых чисел.
    // Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
    // Например, если список ввода (3,44), вывод должен быть 'o3, e44'.
    public static String evensAndOdds(String numbers) {
        throw new UnsupportedOperationException();
    }

    //Вернуть список всех строк, которые начинаются с буквы «а» и имеют ровно 3 буквы
    public static List<String> searchForThreeLetterWordsStartingWithA(List<String> list) {
        List<String>stringList = list.stream()
                .filter(s -> s.length() == 3)
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        return stringList;
    }

}

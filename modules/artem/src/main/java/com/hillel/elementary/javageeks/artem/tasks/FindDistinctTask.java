package com.hillel.elementary.javageeks.artem.tasks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDistinctTask {

    // Вернуть список с уникальными задачами (доп. сложность - с уникальными именами)
    public static List<Task> allDistinctTasks(List<Task> tasks) {
        List<Task> listOfUniqueTasks = tasks.stream()
                .distinct()
                .collect(Collectors.toList());
        return listOfUniqueTasks;
    }

    // Найти 5 первых (по дате создания) задач по чтению, вернуть имя задачи
    public static List<String> top5ReadingTaskNames(List<Task> tasks) {
        List<String> list = tasks.stream()
                .filter(i -> i.getType() == TaskType.READING)
                .sorted((i,j) -> i.getCreationDate().compareTo(j.getCreationDate()))
                .map(i->i.getName())
                .limit(5)
                .collect(Collectors.toList());
        return list;
    }

    // Посчитать количество задач указанного типа
    public static Long countAllTasksByType(List<Task> tasks, TaskType type) {
        long counter = tasks.stream()
                .map(Task::getType)
                .filter(i->i.equals(type))
                .count();
        return counter;
    }

    // Вернуть все уникальные теги задач
    public static List<String> getAllDistinctTags(List<Task> tasks) {
        List<String> listOfUniqueTags = tasks.stream()
                .map(Task::getTags)
                .flatMap(tags -> tags.stream())
                .distinct()
                .collect(Collectors.toList());


        return listOfUniqueTags;
    }

    // Проверить у всех ли задач по чтению есть тег "Books"
    public static Boolean isAllReadingTasksWithTagBooks(List<Task> tasks)    {
        boolean tagExist = tasks.stream()
                .filter(i -> i.getType() == TaskType.READING)
                .allMatch(i ->i.getTags ().contains ("Books"));
        return tagExist;
    }

    //Сконкатенировать все названия задач в одну надпись через "***"
    public static String joinAllTaskTitles(List<Task> tasks) {
        String finalString = tasks.stream()
                .map(Task::getName)
                .reduce((i,j)->i+"***"+j).get();
        return finalString;
    }

    // Вернуть строку с числами, перечисленными через запятую на основе заданного списка целых чисел.
    // Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
    // Например, если список ввода (3,44), вывод должен быть 'o3, e44'.
    public static String evensAndOdds(String numbers) {
      String str =  Stream.of(numbers)
                .flatMap (i -> Arrays.asList (i.split (","))
                .stream ())
                .map(String::trim)
                .filter (p->!p.isEmpty ())
                .map (Integer::parseInt)
                .map(p->(p % 2 == 0 ? "e" + p : "o" + p))
                .reduce((i,j) -> (i + "," + j))
                .orElse ("");
      return str;
    }

    //Вернуть список всех строк, которые начинаются с буквы «а» и имеют ровно 3 буквы
    public static List<String> searchForThreeLetterWordsStartingWithA(List<String> list) {
        List<String> listOfThreeLetterWordsStartingWithA = list.stream()
                .filter(i -> i.length() == 3)
                .filter(j -> j.substring(0,1).equals("a"))
                .collect(Collectors.toList());
        return listOfThreeLetterWordsStartingWithA;
    }


}
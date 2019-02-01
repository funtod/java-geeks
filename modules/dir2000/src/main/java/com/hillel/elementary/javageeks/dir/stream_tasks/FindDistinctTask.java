package com.hillel.elementary.javageeks.dir.stream_tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDistinctTask {

  // Вернуть список с уникальными задачами (доп. сложность - с уникальными именами)
  public static List<Task> allDistinctTasks(List<Task> tasks) {
    return tasks.stream()
            .distinct()
            .collect(Collectors.toList());
  }

  // Вернуть список задач с уникальными именами (доп. сложность)
  public static List<Task> tasksWithDistinctNames(List<Task> tasks) {
    return tasks.stream()
            .collect(Collectors.toMap(Task::getName, Function.identity()
                    , (taskOne, taskTwo) -> taskOne))
            .values()
            .stream()
            .collect(Collectors.toList());
  }

  // Найти 5 первых (по дате создания) задач по чтению, вернуть имена задач
  public static List<String> top5ReadingTaskNames(List<Task> tasks) {
    return tasks.stream()
            .filter(task -> task.getType().equals(TaskType.READING))
            .sorted((o1, o2) -> o1.getCreationDate().compareTo(o2.getCreationDate()))
            .limit(5)
            .map(task -> task.getName())
            .collect(Collectors.toList());
  }

  // Посчитать количество задач указанного типа
  public static Long countAllTasksByType(List<Task> tasks, TaskType type) {
    return tasks.stream()
            .filter(task -> task.getType().equals(type))
            .count();
  }

  // Вернуть все уникальные теги задач
  public static List<String> getAllDistinctTags(List<Task> tasks) {
    return tasks.stream()
            .flatMap(task -> task.getTags().stream())
            .distinct()
            .collect(Collectors.toList());
  }

  // Проверить у всех ли задач по чтению есть тег "Books"
  public static Boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
    return tasks.stream()
            .filter(task -> task.getType().equals(TaskType.READING))
            .allMatch(task -> task.getTags().contains("Books"));
  }

  //Сконкатенировать все названия задач в одну надпись через "***"
  public static String joinAllTaskTitles(List<Task> tasks) {
    return tasks.stream()
            .map(task -> task.getName())
            .reduce("", (s, s2) -> s + (s.length() > 0 ? "***" : "") + s2);
  }

  // Вернуть строку с числами, перечисленными через запятую на основе заданного списка целых чисел.
  // Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
  // Например, если список ввода (3,44), вывод должен быть 'o3, e44'.
  public static String evensAndOdds(String numbers) {
    if (numbers == null || numbers.equals("")) {
      return numbers;
    }
    return Arrays.stream(numbers.split(","))
            .map(val -> val.replace(" ", ""))
            .map(val -> Integer.valueOf(val))
            .map(val -> val % 2 == 0 ? "e" + val : "o" + val)
            .reduce("", (s1, s2) -> s1 + (s1.length() > 0 ? "," : "") + s2);
  }

  //Вернуть список всех строк, которые начинаются с буквы «а» и имеют ровно 3 буквы
  public static List<String> searchForThreeLetterWordsStartingWithA(List<String> list) {
    return list.stream()
            .filter(str -> str.startsWith("a"))
            .filter(str -> str.length() == 3)
            .collect(Collectors.toList());
  }

}

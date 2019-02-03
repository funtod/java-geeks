package com.hillel.elementary.javageeks.oleg.my_labs.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDistinctTask {

    // Вернуть список с уникальными задачами (доп. сложность - с уникальными именами)
    public static List<Task> allDistinctTasks(List<Task> tasks) {
        List<Task> resultList = new LinkedList<> ();
        resultList = tasks.stream ().distinct ().collect (Collectors.toList ());
        return resultList;
    }

    // Найти 5 первых (по дате создания) задач по чтению, вернуть имя задачи
    public static List<String> top5ReadingTaskNames(List<Task> tasks) {
        List<String> resultList = new ArrayList<> ();
        resultList = tasks.stream ().filter (p->p.getType ()==TaskType.READING)
        .sorted ((o1, o2) -> o1.getCreationDate ().compareTo (o2.getCreationDate ()))
                .limit (5).map (p -> p.getName ())
                .collect (Collectors.toList ());
        return resultList;
    }

    // Посчитать количество задач указанного типа
    public static Long countAllTasksByType(List<Task> tasks, TaskType type) {
        Long counter;
        counter = tasks.stream ().map (p -> p.getType ()).filter (type::equals).count ();
        return counter;
    }

    // Вернуть все уникальные теги задач
    public static List<String> getAllDistinctTags(List<Task> tasks) {
        List<String> resultList;
        resultList= tasks.stream ().map(Task::getTags).flatMap (Collection::stream)
                .distinct ()
                .collect(Collectors.toList());
        return resultList;
    }

    // Проверить у всех ли задач по чтению есть тег "Books"
    public static Boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        Boolean result;
        result=tasks.stream ().filter (p->p.getType ()==TaskType.READING)
                .allMatch (p->p.getTags ().contains ("Books"));
        return result;
    }

    //Сконкатенировать все названия задач в одну надпись через "***"
    public static String joinAllTaskTitles(List<Task> tasks) {
        String resultString;
        resultString = tasks.stream ()
                .map(p->p.getName ())
                .collect (Collectors.joining ("***"));

        return resultString;
    }

    // Вернуть строку с числами, перечисленными через запятую на основе заданного списка целых чисел.
    // Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
    // Например, если список ввода (3,44), вывод должен быть 'o3, e44'.
    public static String evensAndOdds(String numbers) {
        String result;
        result= Stream.of (numbers).flatMap (p-> Arrays.asList (p.split (",")).stream ())
                .map(String::trim)
                .filter (p->!p.isEmpty ())
                .map (Integer::parseInt)
                .map(p->(p % 2 == 0 ? "e" + p : "o" + p))
                .reduce((s1,s2)->s1+","+s2)
                .orElse ("");
        return result;
    }

    //Вернуть список всех строк, которые начинаются с буквы «а» и имеют ровно 3 буквы
    public static List<String> searchForThreeLetterWordsStartingWithA(List<String> list) {
        List<String> resultList = new ArrayList<> ();
        resultList = list.stream ().filter (p -> p.startsWith ("a")).filter (p -> p.length () == 3)
                .collect (Collectors.toList ());
        return resultList;
    }

}

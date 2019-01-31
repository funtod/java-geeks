package com.hillel.elementary.javageeks.examples.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>(numbers.size());
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                evenNumbers.add(i);
            }
        }

        evenNumbers = numbers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        List<String> names = Arrays.asList("John", "Arya", "Sansa");
        Set<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println(upperCaseNames); //output [ARYA, JOHN, SANSA]

        Queue<String> queue = names.stream()
                .filter(n -> !n.isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue); //output [Jaime, Daenerys, Tyrion]

    }
}

package com.hillel.elementary.javageeks.examples.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilterExample {

    public static void main(String[] args) {
        List<String> stringCollection = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

        stringCollection.stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);


        stringCollection
                .stream()
                .map(Person::build)
                .sorted(Comparator.comparing(one -> one.name))
                .forEach(System.out::println);

    }

    static class Person {
        String name;

        private Person(String name) {
            this.name = name;
        }

        public static Person build(String name) {
            return new Person(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
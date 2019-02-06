package com.hillel.elementary.javageeks.examples.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicatedExample {

    public static void main(String[] args) {
        Predicate<String> notEmpty = (s) -> s.length() > 0;

        System.out.println(notEmpty.test("foo"));              // true
        System.out.println(notEmpty.negate().test("foo"));     // false

        Predicate<Object> nonNull = Objects::nonNull;
        Predicate<Object> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        PersonFactory<Person> personFactory = Person::new;
        List<Person> persons = Arrays.asList(
                personFactory.create("Peter", "Parker"),
                null,
                personFactory.create("Jason", "Parker"));

        for (Person person : persons) {
            System.out.println("Person is non null: " + nonNull.test(person));
        }


        System.out.println(filter(persons, (person) -> person.firstName.startsWith("P")));
        System.out.println(filter(persons, (person) -> person.lastName.equals("Parker")));
    }


    public static Iterable<Person> filter(Iterable<Person> persons, Predicate<Person> predicate) {
        List<Person> filtered = new ArrayList<>();
        for (Person person : persons) {
            if (person != null && predicate.test(person)) {
                filtered.add(person);
            }
        }
        return filtered;
    }
}

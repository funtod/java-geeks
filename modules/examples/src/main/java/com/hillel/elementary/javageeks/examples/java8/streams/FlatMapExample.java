package com.hillel.elementary.javageeks.examples.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FlatMapExample {

    public static void main(String[] args) {
        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        List<String> petNames = new ArrayList<>();
        for (Human human : humans) {
            petNames.addAll(human.getPets());
        }

        System.out.println(petNames); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]

        petNames = humans.stream()
                .map(Human::getPets) //преобразовываем Stream<Human> в Stream<List<Pet>>
                .flatMap(Collection::stream)//"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .collect(Collectors.toList());

        petNames = humans.stream()
                .flatMap(human -> human.pets.stream())
                .collect(Collectors.toList());
        System.out.println(petNames);

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}}; // массив 3 на 2

        int[] newArr = new int[arr.length * arr[0].length]; // length = 6

        for (int i = 0, index = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[index++] = arr[i][j];
            }
        }
        System.out.println(Arrays.toString(newArr));

        newArr = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream) //преобразовываем IntStream<int[]> в IntStream
                .toArray();


    }




    static class Human {
        private final String name;
        private final List<String> pets;

        Human(String name, List<String> pets) {
            this.name = name;
            this.pets = pets;
        }

        public String getName() {
            return name;
        }

        public List<String> getPets() {
            return pets;
        }
    }
}

package com.hillel.elementary.javageeks.examples.classes.anonymous;

import java.util.Arrays;
import java.util.Comparator;

public class Anonymous {

    public static void doSmth() {

        Animal[] animals = new Animal[1000];

        Arrays.sort(animals, new AnimalComparator() {
            @Override
            public boolean returnTrue() {
                return true;
            }

            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.age - o2.age;
            }
        });
    }
}

interface AnimalComparator extends Comparator<Animal> {

    public boolean returnTrue();
}

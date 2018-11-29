package com.hillel.elementary.javageeks.examples.collections;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            list.add((int) (Math.random() * 71) + "Y")
                    ;
        System.out.println(list + "список");

        TreeSet<String> set = new TreeSet<>(list);
        System.out.println(set + "множество");
        System.out.println(set.add("5 Element")); // добавление(isAdded=true)
        System.out.println(set.add("5 Element")); // добавление(isAdded=false)
        // после добавления
        System.out.println(set + "add");
        // извлечение наибольшего и наименьшего элементов
        System.out.println(set.last() + " " + set.first());
    }
}

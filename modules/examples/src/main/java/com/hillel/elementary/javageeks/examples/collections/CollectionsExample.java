package com.hillel.elementary.javageeks.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class CollectionsExample {

    public static void main(String[] args) {
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer n, Integer m) {
                return m.compareTo(n);
            }
        };
        ArrayList<Integer> list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        Collections.shuffle(list);
        out.print(list);
        Collections.sort(list, comp);
        out.print(list);
        Collections.reverse(list);
        out.print(list);
        Collections.rotate(list, 3);
        out.print(list);
        out.println("min: " + Collections.min(list, comp));
        out.println("max: " + Collections.max(list, comp));
        List<Integer> singl = Collections.singletonList(71);
        out.print(singl);
        singl.add(21); // ошибка времени выполнения

    }
}

package com.hillel.elementary.javageeks.examples.strings;

import java.util.Arrays;
import java.util.Comparator;

public class Split {

    public static String[] getSortedNames(String text) {
        String names = text.trim(); // удаление пробелов по краям строки
        String arrayOfNames[] = names.split(" "); // разбиение строки на подстроки, где "пробел" — разделитель

        Arrays.sort(arrayOfNames, new Comparator<String>() { //используем компаратор для сортировки
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        return arrayOfNames;
    }
}

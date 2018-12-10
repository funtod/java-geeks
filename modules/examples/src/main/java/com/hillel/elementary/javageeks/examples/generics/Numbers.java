package com.hillel.elementary.javageeks.examples.generics;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Numbers<N extends Number> extends ArrayList<N> {

    public N totalSumOfValues() {
        return null;
    }

    public static void main(String[] args) {
        Numbers<Number> numbers = new Numbers<>();
        numbers.add(1);
        numbers.add(1.1);
        numbers.add(1f);

        Numbers<?> wildNumbers = numbers;

        Collections.reverse(wildNumbers);

        System.out.println(wildNumbers);
    }
}
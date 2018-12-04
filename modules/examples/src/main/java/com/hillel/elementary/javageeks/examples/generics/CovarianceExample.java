package com.hillel.elementary.javageeks.examples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovarianceExample {

    public static void main(String[] args) {
        Cat[] cats = new Cat[0];
        Animal[] animals = new Animal[0];

        animals = cats;
//        cats = animals;

        Integer[] myInts = {1, 2, 3, 4};
        Number[] myNumber = myInts;
        myNumber[0] = 3.14;


        List<Integer> listOfInts = Arrays.asList(1,2,3,4,5);
//        List<Number> listOfNums = myInts; //compiler error
//        listOfNums.add(3.14); //heap polution


        Integer[] arrayOfInts = {1,2,3,4,5};
        Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(sum(myInts));
        System.out.println(sum(myLongs));
        System.out.println(sum(myDoubles));

        List<Long> listOfLongs = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Double> listOfDoubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);


        System.out.println(sum(listOfInts)); //compiler error
        System.out.println(sum(listOfLongs)); //compiler error
        System.out.println(sum(listOfDoubles)); //compiler error
    }

    public static long sum(Number[] numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;
    }

    public static long sum(List<? extends Number> numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
//        numbers.add(1);
        return summation;
    }

}

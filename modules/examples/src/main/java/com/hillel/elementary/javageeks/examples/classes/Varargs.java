package com.hillel.elementary.javageeks.examples.classes;

import java.util.Hashtable;

public class Varargs {

    public static int getSum(int... numbers) {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }

    //в случае если нам нужке хотя бы 1 аргумент
    public static int getSum(int firstNumber, int... numbers) {
        int sum = firstNumber;
        for(int number: numbers) { //numbers превратились в массив
            sum += number;
        }
        Hashtable h = new Hashtable();
        h.put("a"," a");
        return sum;
    }

    // ошибка компиляции
    // public static int getSum(int[] numbers) { }
}

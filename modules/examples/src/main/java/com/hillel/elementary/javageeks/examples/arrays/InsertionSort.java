package com.hillel.elementary.javageeks.examples.arrays;

public class InsertionSort {


    public static void sort(int[] input) {

        int pointer = 0;
        int leftPointer;

        while (++pointer < input.length) {
            int currentVal = input[pointer];
            int previousVal = input[pointer - 1];

            if (currentVal < previousVal) {
                leftPointer = pointer;

                while ((leftPointer - 1) >= 0) {
                    int lastPointVal = input[leftPointer - 1];
                    if (currentVal < lastPointVal) {
                        input[leftPointer--] = lastPointVal;
                    } else {
                        break;
                    }
                }
                input[leftPointer] = currentVal;
            }
        }

    }
}

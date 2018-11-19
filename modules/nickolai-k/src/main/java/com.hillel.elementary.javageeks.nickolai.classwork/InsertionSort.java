package com.hillel.elementary.javageeks.nickolai.classwork;
//TODO: Fix custom solution
public class InsertionSort {
    public static void sort(int[] input) {
        int pointer = 0;
        int lastPoint = pointer;
        int counter = input.length - 1;
        int tempBuff;
        while (counter <= input.length - 1) {
            int currentVal = input[pointer];
            int secondVal = input[pointer + 1];

            if (currentVal > secondVal) {
                pointer++;
            } else {
                lastPoint = pointer;
                while (currentVal < secondVal) {
                    tempBuff = currentVal;
                    currentVal = secondVal;
                    secondVal = tempBuff;
                    input[pointer] = currentVal;
                    input[pointer] = secondVal;
                    if (pointer != 0) {
                        pointer--;
                    } else {
                        break;
                    }
                }
                pointer = lastPoint;
            }
            pointer++;
        }
    }
}

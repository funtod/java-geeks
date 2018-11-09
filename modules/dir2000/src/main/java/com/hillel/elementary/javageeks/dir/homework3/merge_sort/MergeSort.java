package com.hillel.elementary.javageeks.dir.homework3.merge_sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int [] array) {
        mergeSortRange(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSortRange(int [] array, int leftBound, int rightBound){
        if (leftBound == rightBound)
            return;

        int leftBoundArrayOne = leftBound;
        int rightBoundArrayOne = leftBound + (rightBound - leftBound)/2;
        int leftBoundArrayTwo = rightBoundArrayOne + 1;
        int rightBoundArrayTwo = rightBound;
        if (rightBound - leftBound > 1) {
            mergeSortRange(array, leftBoundArrayOne, rightBoundArrayOne);
            mergeSortRange(array, leftBoundArrayTwo, rightBound);
        }

        int [] merged = new int [rightBound - leftBound + 1];
        int pointer = 0;
        int pointertArrayOne = leftBoundArrayOne;
        int pointerArrayTwo = leftBoundArrayTwo;
        int valueOne, valueTwo;
        while (pointer < merged.length) {
            if (pointertArrayOne > rightBoundArrayOne) {
                merged[pointer] = array[pointerArrayTwo++];
            } else if (pointerArrayTwo > rightBoundArrayTwo){
                merged[pointer] = array[pointertArrayOne++];
            } else {
                valueOne = array[pointertArrayOne];
                valueTwo = array[pointerArrayTwo];
                if (valueOne > valueTwo) {
                    merged[pointer] = array[pointerArrayTwo++];
                } else {
                    merged[pointer] = array[pointertArrayOne++];
                }
            }
            pointer++;
        }
        System.arraycopy(merged, 0, array, leftBound, merged.length);
    }
}

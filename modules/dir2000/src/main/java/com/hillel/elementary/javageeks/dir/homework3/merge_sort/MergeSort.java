package com.hillel.elementary.javageeks.dir.homework3.merge_sort;

import java.util.Arrays;

public class MergeSort {
    static int [] arrayToSort;

    public static void main(String[] args) {
        mergeSort(new  int[] {5, 4, -1, 12, 3, 7, 78});
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static int[] mergeSort(int [] source) {
        arrayToSort = source;
        mergeSortRange(0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private static void mergeSortRange(int leftBound, int rightBound){
        if (leftBound == rightBound)
            return;

        int leftBoundArrayOne = leftBound;
        int rightBoundArrayOne = leftBound + (rightBound - leftBound)/2;
        int leftBoundArrayTwo = rightBoundArrayOne + 1;
        int rightBoundArrayTwo = rightBound;
        if (rightBound - leftBound > 1) {
            mergeSortRange(leftBoundArrayOne, rightBoundArrayOne);
            mergeSortRange(leftBoundArrayTwo, rightBound);
        }

        int [] merged = new int [rightBound - leftBound + 1];
        int pointer = 0;
        int pointertArrayOne = leftBoundArrayOne;
        int pointerArrayTwo = leftBoundArrayTwo;
        int valueOne, valueTwo;
        while (pointer < merged.length) {
            if (pointertArrayOne > rightBoundArrayOne) {
                merged[pointer] = arrayToSort[pointerArrayTwo++];
            } else if (pointerArrayTwo > rightBoundArrayTwo){
                merged[pointer] = arrayToSort[pointertArrayOne++];
            } else {
                valueOne = arrayToSort[pointertArrayOne];
                valueTwo = arrayToSort[pointerArrayTwo];
                if (valueOne > valueTwo) {
                    merged[pointer] = arrayToSort[pointerArrayTwo++];
                } else {
                    merged[pointer] = arrayToSort[pointertArrayOne++];
                }
            }
            pointer++;
        }
        System.arraycopy(merged, 0, arrayToSort, leftBound, merged.length);
    }
}

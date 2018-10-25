package com.hillel.elementary.javageeks.examples.arrays;

public class BinarySearch {

    public static int find(int numberToFind, int[] array) {
        if (array == null || array.length == 0) return -1;

        int index = array.length / 2;
        int oldIndex;

        while (true) {
            int currentElement = array[index];
            oldIndex = index;
            if (currentElement == numberToFind) {
                return index;
            } else if (currentElement < numberToFind) {
                index = index/2 + index;
            } else {
                index = index/2;
            }
            if (oldIndex == index) break;
        }

        return -1;
    }
}

package com.hillel.elementary.javageeks.nickolai.classwork;

public class BinarySearch {

    public static int find(int seach, int[] arr) {

        if(arr == null) { return -1; }

        int low = 0;
        int hight = arr.length -1;
        int middle;
        int guess;

        while ((low <= hight)) {
            middle = (low + hight);
            guess = arr[middle];
            if (guess == seach) {
                return guess;
            } else if (guess > seach) {
                hight = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}

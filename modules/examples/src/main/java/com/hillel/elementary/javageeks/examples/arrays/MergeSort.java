package com.hillel.elementary.javageeks.examples.arrays;

public class MergeSort {

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left == right) return;
        int middle = (left + right) / 2;

        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);

        merge(array, left, right, middle);
    }

    private static void merge(int[] array, int left, int right, int middle) {
        int[] tmpArray = new int[right - left + 1];
        int tmpIndex = 0;
        int leftIndex = left;
        int rightIndex = middle + 1;

        while(leftIndex <= middle && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                tmpArray[tmpIndex++] = array[leftIndex++];
            } else {
                tmpArray[tmpIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            tmpArray[tmpIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            tmpArray[tmpIndex++] = array[rightIndex++];
        }

        System.arraycopy(tmpArray, 0, array, left, tmpArray.length);
    }
}

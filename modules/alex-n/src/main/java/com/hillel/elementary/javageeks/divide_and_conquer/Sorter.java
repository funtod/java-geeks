package com.hillel.elementary.javageeks.divide_and_conquer;

public class Sorter {
    public static int[] mergeSort(int[] array){
        if (array == null) {
            return null;
        }else {
            if (array.length < 2) {
                return array;
            } else {
                int[] leftHalf = new int[array.length / 2];
                int[] rightHalf = new int[array.length - leftHalf.length];
                System.arraycopy(array, 0, leftHalf, 0, leftHalf.length);
                System.arraycopy(array, leftHalf.length, rightHalf, 0, rightHalf.length);
                if (leftHalf.length > 1) {
                    leftHalf = mergeSort(leftHalf);
                }
                if (rightHalf.length > 1) {
                    rightHalf = mergeSort(rightHalf);
                }
                int i = 0;
                int j = 0;
                array = new int[leftHalf.length + rightHalf.length];
                for (int k = 0; k < rightHalf.length + leftHalf.length; k++) {
                    if (i < leftHalf.length && j < rightHalf.length) {
                        if (leftHalf[i] < rightHalf[j]) {
                            array[k] = leftHalf[i++];
                        } else {
                            array[k] = rightHalf[j++];
                        }
                    } else {
                        if (i < j) {
                            array[k] = leftHalf[i++];
                        } else {
                            array[k] = rightHalf[j++];
                        }
                    }
                }
                return array;
            }
        }
    }
}

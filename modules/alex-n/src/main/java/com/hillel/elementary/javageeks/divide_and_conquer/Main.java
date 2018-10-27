package com.hillel.elementary.javageeks.divide_and_conquer;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{4,3,2,1,4,5,7,3,12,7,84,34,5,6,7,-1};
        unsortedArray = Sorter.mergeSort(unsortedArray);
        for (int elem : unsortedArray){
            System.out.printf(elem + ", ");
        }
    }
}

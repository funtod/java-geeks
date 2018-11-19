package com.hillel.elementary.javageeks.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] array;
        System.out.println("Please input your numbers separated by commas:");

        //This all just to don't ask user about array length
        String[] userInputArray = new BufferedReader(new InputStreamReader(System.in)).readLine().trim().split(",");
        array = new int[userInputArray.length];
        for (int i = 0; i < userInputArray.length; i++) {
            try {
                array[i] = Integer.parseInt(userInputArray[i].trim());
            }catch (NumberFormatException e){
                System.out.println("Wrong input data! Must be integer numbers separated by commas.");
                System.exit(1);
            }
        }
        array = Sorter.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

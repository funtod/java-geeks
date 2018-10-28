package com.hillel.elementary.javageeks.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] array;
        String userInput;
        System.out.println("Please input your numbers separated by commas:");

        //This all just to don't ask user about array length
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        userInput = bufferedReader.readLine().trim();
        String[] userInputArray = userInput.split(",");
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
        for (int elem : array) {
            System.out.printf(elem + " ");
        }
    }
}

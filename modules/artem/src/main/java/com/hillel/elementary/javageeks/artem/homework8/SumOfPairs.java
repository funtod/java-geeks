package com.hillel.elementary.javageeks.artem.homework8;

import java.util.ArrayList;

public class SumOfPairs {

    public static int sumofPairs( ArrayList<Integer> listOfNumbers){
        int result;
        while(listOfNumbers.size() != 1) {
            for (int i = 0; i < listOfNumbers.size() - 1; i++) {
                listOfNumbers.set(i, listOfNumbers.get(i) + listOfNumbers.get(i + 1));
                listOfNumbers.remove(i + 1);
            }
        }
        return result = listOfNumbers.get(0);
    }

}

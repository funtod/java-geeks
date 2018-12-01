package com.hillel.elementary.javageeks.artem.homework6;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CountQuantityOfEachWord {
    public static ArrayList returnQuantityOfEachWord(String fraze){

        ArrayList<String> startListOfWords =  addToList(fraze);
        ArrayList<String> finalListOfWords = getInfoAboutEachWord(startListOfWords);

        deleteRubish(finalListOfWords);

        return finalListOfWords;
    }

    public static void deleteRubish(ArrayList<String> finalListOfWords){
    int i = 0;
        for (int j = 0; i < finalListOfWords.size();) {
           if (finalListOfWords.get(j).equals(finalListOfWords.get(i))){
               if (j != i) {
               finalListOfWords.remove(i); }
           }
           i++;
           if (i == finalListOfWords.size()){
           i = 0; j++;
           }
        }
    }

    public static ArrayList getInfoAboutEachWord(ArrayList<String> listOfWords){
        ArrayList<String> finalListOfWords = new ArrayList<>();
        int indexOfCheckedItem = 0, quantity = 1, indexOfActualItem = 0;
        while (indexOfCheckedItem != listOfWords.size()) {
            if (listOfWords.get(indexOfCheckedItem).equals(listOfWords.get(indexOfActualItem))) {
                if (indexOfCheckedItem != indexOfActualItem) {
                    quantity++;
                }
            }
            indexOfActualItem++;

            if(indexOfActualItem == listOfWords.size()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(listOfWords.get(indexOfCheckedItem)).append(" met ").append(quantity).append(" times");
            finalListOfWords.add(stringBuilder.toString());
            indexOfCheckedItem++;
                indexOfActualItem = 0; quantity = 1;
            }
        }
        return finalListOfWords;
    }

    public static ArrayList addToList(String fraze){
        ArrayList<String> listOfWords = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(fraze,",?!./ ");

        while(stringTokenizer.hasMoreTokens()){
            listOfWords.add(stringTokenizer.nextToken());
        }
        return listOfWords;
    }


}

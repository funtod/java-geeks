package com.hillel.elementary.javageeks.artem.homework6;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CountQuantityOfEachWord {
    public static ArrayList returnQuantityOfEachWord(String fraze){

        ArrayList<String> startListOfWords = new ArrayList<>();
        ArrayList<String> finalListOfWords = new ArrayList<>();

        startListOfWords = addToList(fraze);
        finalListOfWords = getInfoAboutEachWord(startListOfWords);
        deleteRubish(finalListOfWords);

        return finalListOfWords;
    }

    public static void deleteRubish(ArrayList<String> finalListOfWords){
    int i = 0;
        for (int j = 0; i < finalListOfWords.size();) {
           if (finalListOfWords.get(j).equals(finalListOfWords.get(i))){
               if (j == i) {}
               else { finalListOfWords.remove(i); }
           }
           i++;
           if (i == finalListOfWords.size()){
           i = 0; j++;
           }
        }
    }

    public static ArrayList getInfoAboutEachWord(ArrayList<String> listOfWords){
        ArrayList<String> finalListOfWords = new ArrayList<>();
        int j = 0, quantity = 1, i = 0, k = 0;
        while (j != listOfWords.size()) {
            if (listOfWords.get(j).equals(listOfWords.get(i))) {
                if (j == i) {
                } else {
                    quantity++;
                }
            }
            i++;

            if(i == listOfWords.size()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(listOfWords.get(j)).append(" met ").append(quantity).append(" times");
                finalListOfWords.add(stringBuilder.toString());
            k++; j++;
            i = 0; quantity = 1;
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

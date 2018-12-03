package com.hillel.elementary.javageeks.ruslanTask5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {

    public String[] returnUniqArrayDevide(String str) {


        String[] arr = str.replaceAll("[,.]", "").split(" ");

        String[] arrResult = new String[toUniqueArray(arr).length];
        String REGEX_FIND_WORD;

         for (int i = 0; i < toUniqueArray(arr).length; i++) {
             REGEX_FIND_WORD="\\b"+arr[i]+"\\b";
             Pattern pattern = Pattern.compile(REGEX_FIND_WORD);
             Matcher matcher = pattern.matcher(str);

            int count = 0;

            while (matcher.find()) {
                count++;
            }
            if (count % 2 == 0) {
                arrResult[i] = arr[i] + ":" + count;
            }
        }
        return notNUllArray(arrResult);
    }


    public static boolean isUnique(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if ((value.toLowerCase()).equals(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static String[] toUniqueArray(String[] array) {
        String[] temp = new String[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (isUnique(temp, array[i])) {
                temp[counter++] = array[i];
            }
        }
        String[] uniqueArray = new String[counter];
        System.arraycopy(temp, 0, uniqueArray, 0, uniqueArray.length);
        return uniqueArray;
    }

    public static String[] notNUllArray(String[] str){
        int countForNewArray=0;
        for (int i = 0; i < str.length; i++) {
            if(str[i]!=null) countForNewArray++;
        }

        int count = 0;
        String[] ars = new String[countForNewArray];
        for (int i = 0; i < str.length; i++) {
            if(str[i]!=null){
                ars[count]=str[i];
                count++;
            }
        }

        return ars;
    }
}
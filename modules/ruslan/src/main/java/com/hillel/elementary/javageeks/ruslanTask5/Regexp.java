package com.hillel.elementary.javageeks.ruslanTask5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public  static String findWorld(String text) {

        //String text = "I would like to find Ruslan Ruslan";

        String[] arr = text.split(" ");
        String[] arrResult = new String[toUniqueArray(arr).length];

        for (int i = 0; i < toUniqueArray(arr).length; i++) {

            Pattern pattern = Pattern.compile(arr[i]);
            Matcher matcher = pattern.matcher(text);

            int count = 0;
            while(matcher.find()){
                count++;
            }
            arrResult[i]=arr[i]+":"+count;
        }
        System.out.println(Arrays.toString(arrResult));
    }

    public static boolean isUnique(String[] array, String value) {

        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
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
}

package com.hillel.elementary.javageeks.oleg.my_labs.lab_2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Polindrom {

    public static String[] lineSplit(String numbers){
        StringTokenizer stringTokenizer=new StringTokenizer (numbers,", ");
        int count=stringTokenizer.countTokens ();
        String[] numberInText=new String[count];
        for (int i=0; i<numberInText.length; i++){
            numberInText[i]=stringTokenizer.nextToken ();
        }
        return numberInText;
    }

    public static boolean isPolindrom(int number){
        char[] num=String.valueOf (number).toCharArray ();
        boolean result=true;
        for (int i=0, j=num.length-1; i<num.length; i++,j--){
            if(num[i]!=num[j]){
                return false;
            }
        }
        return result;
    }

    public static void printPolindromNumber(String[] numbers){
        for (int i=0; i<numbers.length; i++){
            int number=Integer.parseInt (numbers[i]);
            if(isPolindrom (number)){
                System.out.println ("Number "+ number + " is polindrom");
            }
        }
    }
}

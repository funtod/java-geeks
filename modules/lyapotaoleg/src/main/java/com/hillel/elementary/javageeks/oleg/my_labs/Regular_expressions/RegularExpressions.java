package com.hillel.elementary.javageeks.oleg.my_labs.Regular_expressions;

import java.util.regex.Pattern;

public class RegularExpressions {

    public  static String findMinLength(String str){
        Pattern pattern=Pattern.compile ("\\s+");
        String [] words=pattern.split (str);
        int minLength=words[0].length ();
        String result="";

        for (String word:words){
            if(word.length ()<minLength){
                minLength=word.length ();
            }
        }
        for (String word:words){
            if (word.length ()==minLength){
                result=result.trim ()+ " "+ word;
            }
        }
        return  result;
    }

    public static String findMaxLength(String str){
        Pattern pattern=Pattern.compile ("\\s+|! ");
        String [] words=pattern.split (str);
        int maxLength=words[0].length ();
        String result="";
        for (String word:words){
            if (word.length ()>maxLength){
                maxLength=word.length ();
            }
        }
        for (String word:words){
            if (word.length ()==maxLength){
                result=result.trim () +word;
            }
        }
        return result;
    }
}

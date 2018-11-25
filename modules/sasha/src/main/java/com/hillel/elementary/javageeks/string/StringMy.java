package com.hillel.elementary.javageeks.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMy {
    public static StringBuilder addWord(String str,String addedWord){
        Pattern pattern = Pattern.compile(".*ax");
        Matcher matcher = pattern.matcher(str);

        StringBuilder stringBuilder = new StringBuilder();

        String txt = "ax" + addedWord;

        while (matcher.find()){
            stringBuilder.append(matcher.group().replaceAll("ax",txt));

        }
        return stringBuilder;
    }



}

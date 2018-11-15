package com.hillel.elementary.javageeks.examples.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static boolean hasVasya(String text) {
        Pattern pattern = Pattern.compile(".*Vasya([abc]*|[fgt]*)\\d*");

        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }

        return matcher.matches();
    }


    public static void myMatches(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()) {
            System.out.println("First group: "+ matcher.group(1));
            System.out.println("Second group: "+ matcher.group(2));
        } else {
            System.out.println("nothing");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        myMatches("([a-z]*)([a-z]+)", "abdcxyz");
        myMatches("([a-z]?)([a-z]+)", "abdcxyz");
        myMatches("([a-z]+)([a-z]*)", "abdcxyz");
        myMatches("([a-z]?)([a-z]?)", "abdcxyz");
    }

}

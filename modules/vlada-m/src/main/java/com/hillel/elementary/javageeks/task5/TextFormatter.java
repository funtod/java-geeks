package com.hillel.elementary.javageeks.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextFormatter {
    public static String format(String s) {
        String regex = "([A-Za-z-]+\\s)|([^A-Za-z-]*[A-Za-z-]+[^A-Za-z-]*)";
        String testRegex = "(\\s|\\,|\\.|$|\\?|\\!|\\”|\\“|\\—|\\(|\\))*([A-Za-z]+)(\\s|\\,|\\.|$|\\?|\\!|\\”|\\“|\\—|\\(|\\))*$";
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s);
        String empty = "";
        while (m2.find()) {
            String word = m2.group();
            Matcher matcher = Pattern.compile(testRegex).matcher(word);
            if (matcher.matches()) {
                String group = matcher.group();
                String s1 = group.replaceFirst("[A-Za-z]", matcher.group(2).substring(0, 1).toUpperCase());
                empty = empty + s1;

            } else {
                empty = empty + word;
            }
        }
        return empty;
    }
}

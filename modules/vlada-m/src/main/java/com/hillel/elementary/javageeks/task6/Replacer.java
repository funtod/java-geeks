package com.hillel.elementary.javageeks.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public static String replace(String pathname) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(
                Replacer.class.getResourceAsStream(pathname));
        BufferedReader in = new BufferedReader(inputStreamReader);

        String regex = "(^\\s*public\\s+)|(.*)";
        Pattern pattern = Pattern.compile(regex);
        String line;
        StringBuilder result = new StringBuilder();
        try {
            while ((line = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    String groupToReplace = matcher.group(1);
                    if (groupToReplace != null) {
                        result.append(groupToReplace.replace("public", "private"));
                    }
                    String groupWithoutPublic = matcher.group(2);
                    if (groupWithoutPublic != null) {
                        result.append(groupWithoutPublic);
                    }
                }
                result.append("\n");
            }
        } finally {
            inputStreamReader.close();
            in.close();
        }
        return result.toString();
    }

}

package com.hillel.elementary.javageeks.text_formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatter {

    public final String reformatLineFeedsByMaxWidth(String txt, int lineWidth) {
        if (txt != null && !txt.isEmpty()) {
            String textInOneLine = deleteNewLineCharacters(txt);
            Pattern pattern = Pattern.compile("(.{0," + lineWidth + "}\\b?\\.?)");
            Matcher matcher = pattern.matcher(textInOneLine);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                if (matcher.end() < textInOneLine.length()) {
                    stringBuffer.append(matcher.group().trim() + "\n");
                } else {
                    stringBuffer.append(matcher.group().trim());
                }
            }
            return stringBuffer.toString();
        } else {
            return txt;
        }
    }

    public final String textAlignCenter(String txt, int lineWidth) {
        if (txt != null && !txt.isEmpty()) {
            String[] linesArray = txt.split("[\n\r]");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < linesArray.length; i++) {
                stringBuilder.append(addSpacesToStretchWidth(linesArray[i], lineWidth));
            }
            return stringBuilder.toString().trim();
        } else {
            return txt;
        }
    }

    private String addSpacesToStretchWidth(String line, int lineWidth) {
        double modifier;
        String[] wordsArray = line.trim().split("(=?<=\\s+)|(?=\\s+)");

        if (lineWidth > line.length()) {
            int spacesToAdd = lineWidth - line.length();
            //if we need to add more spaces than already are
            if (spacesToAdd > wordsArray.length) {
                modifier = (double) spacesToAdd / (double) (wordsArray.length - 1);
                return addSpaces(wordsArray, modifier).toString();
            } else { //if there more existing spaces than we want to add
                StringBuilder stringBuilder = new StringBuilder();
                modifier = (double) (wordsArray.length - 1) / (double) spacesToAdd;
                for (double i = 0; i < wordsArray.length - 1; i += modifier) {
                    wordsArray[(int) Math.floor(i)] = wordsArray[(int) Math.floor(i)] + " ";
                }
                for (int i = 0; i < wordsArray.length; i++) {
                    stringBuilder.append(wordsArray[i]);
                }
                return stringBuilder.append("\n").toString();
            }
        } else {
            return line;
        }
    }

    private StringBuilder addSpaces(String[] wordArray, double spacesNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        double spaceCounter = 0;
        for (int j = 0; j < wordArray.length - 1; j++) {
            stringBuilder.append(wordArray[j]);
            spaceCounter += spacesNumbers;
            for (int i = 0; i < (int) Math.floor(spaceCounter); i++) {
                stringBuilder.append(" ");
            }
            spaceCounter -= (int) Math.floor(spaceCounter);
        }
        return stringBuilder.append(wordArray[wordArray.length - 1] + "\n");
    }

    private String deleteNewLineCharacters(String txt) {
        return txt.replaceAll("[\n\r]", " ");
    }
}

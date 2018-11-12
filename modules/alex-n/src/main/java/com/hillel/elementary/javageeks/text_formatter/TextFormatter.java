package com.hillel.elementary.javageeks.text_formatter;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatter {

    public String deleteNewLineCharacters(String txt){
        return txt.replaceAll("\n", " ");
    }

    public String addLineFeeds(String txt, int lineWidth){
        Pattern pattern = Pattern.compile("(.{0," + lineWidth +"}\\b\\.?)");
        Matcher matcher = pattern.matcher(txt);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()){
            stringBuffer.append(matcher.group().trim()+"\n");
            System.out.println(matcher.group() +", "+ matcher.start() +", "+ matcher.end());
        }
        return stringBuffer.toString();
    }


    public String textAlignCenter(String txt, int lineWidth){
        String[] linesArray = txt.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linesArray.length; i++) {
            stringBuilder.append(addSpacesToStretchWidth(linesArray[i], lineWidth));
        }
        return stringBuilder.toString();
    }


    //I hope this will work)))
    private String addSpacesToStretchWidth(String line, int lineWidth){
        double modifier;
        String[] wordsArray = line.split("\\s");
        if (lineWidth > line.length()) {
            int spacesToAdd = lineWidth - line.length();
            //if we need to add more spaces than already are
            if (spacesToAdd > wordsArray.length) {
                modifier = spacesToAdd / wordsArray.length;
                return addSpaces(wordsArray, modifier).toString();
            }else{
                //TODO трабл
                StringBuilder stringBuilder = new StringBuilder();
                modifier = wordsArray.length-1 / spacesToAdd;
                for (int i = 0; i < wordsArray.length; i+=modifier) {
                    wordsArray[i] = wordsArray[i] + " ";
                }
                for (int i = 0; i < wordsArray.length; i++) {
                    stringBuilder.append(wordsArray[i]+" ");
                }
                return stringBuilder.append(wordsArray[wordsArray.length-1]+"\n").toString();
            }
        }else{
            return line;
        }
    }


    //TODO test this
    private StringBuilder addSpaces(String[] wordArray, double spacesNumbers){
        StringBuilder stringBuilder = new StringBuilder();
        double spaceCounter = 0;
        for (int j = 0; j < wordArray.length-1; j++) {
            stringBuilder.append(wordArray[j]);
            spaceCounter += spacesNumbers;
            for (int i = 0; i < (int) Math.floor(spaceCounter); i++) {
                stringBuilder.append(" ");
            }
            spaceCounter -= (int) Math.floor(spaceCounter);
        }
        return stringBuilder.append(wordArray[wordArray.length-1]+"\n");
    }


    public static void main(String[] args) {
        TextFormatter tf = new TextFormatter();
        String txt = "some text\nsome new line\nsome another new line.";
//        System.out.println("****************");
//        System.out.println("Initial: " + txt);
//        System.out.println("****************");
//        System.out.println("Delete \\n: " + tf.deleteNewLineCharacters(txt));
//        System.out.println("****************");
//        System.out.println("After split: "+ tf.addLineFeeds(tf.deleteNewLineCharacters(txt), 24));

        System.out.println(tf.textAlignCenter(txt,25));
    }
}

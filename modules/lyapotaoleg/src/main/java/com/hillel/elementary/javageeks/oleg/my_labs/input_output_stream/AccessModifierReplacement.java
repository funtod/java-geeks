package com.hillel.elementary.javageeks.oleg.my_labs.input_output_stream;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AccessModifierReplacement {

    public static String readFromFile(String pathToOldFile){

        if (pathToOldFile==null || pathToOldFile.isEmpty ()){
            System.out.println ("invalid input data entered");
            return null;
        }

        File oldFile=new File (pathToOldFile);
        String str;
        StringBuilder stringBuilder=new StringBuilder ();

        try(BufferedReader bufferedReader=new BufferedReader (
                                          new InputStreamReader (
                                          new FileInputStream (oldFile)))){
            while ((str=bufferedReader.readLine ())!=null){
                stringBuilder.append (str);
            }
        }catch (IOException ex){

        }
        return stringBuilder.toString();
    }



    public static String convert(String str){
        Pattern pattern=Pattern.compile ("(public)(\\s+(static|final)?\\s*?(static|final)?\\s*?\\w+\\s+\\w+((\\s" +
                "?(;|=\\s*.+?;)[\\s\\S]*?)|(\\(.*?\\).*)))");
        Matcher matcher=pattern.matcher (str);
        StringBuffer stringBuffer=new StringBuffer ();
        while (matcher.find ()){
            matcher.appendReplacement (stringBuffer, "private$2");
        }
        matcher.appendTail (stringBuffer);
        System.out.println (stringBuffer.toString ());

        return stringBuffer.toString ();
    }



    public static void writeToFile(String pathToNewFile, String str){

        if(pathToNewFile==null || str==null || pathToNewFile.isEmpty ()){
            System.out.println ("invalid input data entered");
            return;
        }

        File newFile=new File (pathToNewFile);

        try(BufferedWriter bufferedWriter=new BufferedWriter (
                                          new OutputStreamWriter (
                                          new FileOutputStream (newFile)))){
            bufferedWriter.write (str);

        }catch (IOException ex){
            ex.printStackTrace ();
        }
    }

    public static void main(String[] args) {

convert ("public static int find(int numberToFind, int[] array)");
convert ("public final int startAge = 0;");
convert ("public class BinarySearch");
    }

}

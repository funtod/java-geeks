package com.hillel.elementary.javageeks.oleg.my_labs.input_output_stream;

import java.io.*;


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
                stringBuilder.append ("\\n");
            }
        }catch (IOException ex){

        }
        return stringBuilder.toString();
    }



    public static String convert(String str){
        String newText=str.replace ("public","private");
        return newText;
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

//    public static void main(String[] args) {
//        writeToFile ("D://example2.txt",convert (readFromFile ("D://example.txt")));
//
//    }

}

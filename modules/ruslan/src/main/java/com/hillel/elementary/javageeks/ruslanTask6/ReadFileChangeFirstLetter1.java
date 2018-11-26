package com.hillel.elementary.javageeks.ruslanTask6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ReadFileChangeFirstLetter1 {

    public static void main(String[] args) {


      //  URL resource =ReadFileChangeFirstLetter.class.getClassLoader ().getResource ("Test.txt");
      //  String fileFrom = resource.getFile ();

        String FILENAME = "/home/rstepanc/IdeaProjects/java-geeks/modules/ruslan/src/main/resources/Test.txt";
        String sCurrentLine;
        ArrayList<String> str  = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(" ");

                String lineOutput = "";
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].length()!=0) {
                        lineOutput += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase() + " ";
                        str.add(lineOutput);
                    }
                }


                System.out.println(lineOutput);
                WriteFile(FILENAME,str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void WriteFile(String FILENAME,ArrayList<String> str)
            throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILENAME),true));
        for (int i = 0; i < str.size(); i++) {
            writer.write(str.get(i));
            writer.write(System.lineSeparator());

        }
        writer.close();
    }

}
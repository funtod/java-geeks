package com.hillel.elementary.javageeks.myfile;

import java.io.*;
import java.util.LinkedList;

public class MyFile {
    public static LinkedList parseFile(String filePath,String lineSample) {
        File file;
        file = new File(filePath);

        int count = 0;
        LinkedList<Integer> collectionNumber = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                count++;
                if (line.matches(lineSample)) {
                    collectionNumber.add(count);
                }
            }
        }
        catch (IOException e) {
            return new LinkedList();
        }

        return collectionNumber;
    }



}



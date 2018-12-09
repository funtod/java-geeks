package com.hillel.elementary.javageeks.myfile;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;

public class MyFile {
    public static LinkedList parseFile(String[] args) {
        File file = new File(args[0]);

        BufferedReader br = null;

        String st;
        int count = 0;
        LinkedList<Integer> col = new LinkedList<>();

        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                count++;
                if (st.matches(args[1])) {
                    col.add(count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return col;
    }



}



package com.hillel.elementary.javageeks.examples.io;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class FileCopyExample {

    public static void main(String[] args) {
        URL from = BufferedReaderExample.class.getClassLoader().getResource("pride_and_prejudice.txt");
        File toFile = new File("/home/dev/Downloads/copy.txt");

        copy(from.getFile(), toFile.getAbsolutePath());
    }

    public static void copy(String pathToFileFrom, String pathToFileTo) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFileFrom), StandardCharsets.UTF_8));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToFileTo), StandardCharsets.UTF_8));

            char[] buffer = new char[8192];

            for (int n = reader.read(buffer); n != -1; n = reader.read(buffer)) {
                writer.write(buffer, 0, n);
            }

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            //может быть try with resources
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.hillel.elementary.javageeks.ruslanTask6;

import java.io.*;

public class ReadInBUF {

    public static void WorkWithFile (File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder builder = new StringBuilder();

        while ((st = br.readLine()) != null) {
            String[] arrStr = st.split(" ");
            for (int i = 0; i < arrStr.length; i++) {
                if (!arrStr[i].isEmpty()) {
                    builder.append(arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1) + " ");
                }
            }
            builder.append("\n");
        }
        WriteFile(file.toString(), builder.toString());
    }

    public static void WriteFile(String FILENAME, String str) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILENAME)));
        writer.append(str);
        writer.close();
    }
}
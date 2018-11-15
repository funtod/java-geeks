package com.hillel.elementary.javageeks.mostipan.reverse;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Reverse {
    public static void main(String[] args) throws Exception {
        URL from = Reverse.class.getClassLoader().getResource("Test.kt");
        File toFile = new File("/home/sanya/hillel/java-geeks/modules/mostipan/src/main/resources/Reversed.kt");
        refactor(from.getFile(), toFile.getAbsolutePath());
    }

    public static void refactor(String pathToFileFrom, String pathToFileTo) throws Exception {
        BufferedReader fileIn = null;
        BufferedWriter fileOut = null;
        try {
            fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFileFrom), StandardCharsets.UTF_8));
            fileOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToFileTo), StandardCharsets.UTF_8));
            String buffer;

            while ((buffer = fileIn.readLine()) != null) {
                StringBuilder out = new StringBuilder(buffer);
                out.reverse();
                fileOut.write(out.toString());
                if (buffer == null) {
                    break;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

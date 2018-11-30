package com.hillel.elementary.javageeks.ruslanTask6;

import java.io.*;

public class ReadInBUF {

    public static void writeFile(String FILENAME, String str) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILENAME)));
        writer.append(str);
        writer.close();
    }

    public static byte[] toLow(byte[] arr){

        for (int i = 0; i< arr.length; i++) {
            arr[i] = (byte) Character.toLowerCase(arr[i]);
        }
        return arr;
    }

    public static String toUp(byte[] arr){

        boolean inWord = false;
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] >= 97 && arr[i] <= 122) {
                if (inWord) {
                    continue;
                }
                arr[i] = (byte) Character.toUpperCase(arr[i]);
                inWord = true;
            } else {
                inWord = false;
            }
        }
        return new String(arr);
    }
    

    public static byte[] getFileBytes(File file) throws IOException {

        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {

            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1)
                ous.write(buffer, 0, read);

        } finally {

            try {

                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }
            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
}
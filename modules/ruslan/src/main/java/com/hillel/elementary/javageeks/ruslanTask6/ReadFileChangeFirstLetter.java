package com.hillel.elementary.javageeks.ruslanTask6;

import java.io.*;
import java.net.URL;

public class ReadFileChangeFirstLetter {

    public static void main(String[] args) throws IOException {
        URL resource =ReadFileChangeFirstLetter.class.getClassLoader ().getResource ("Test.txt");
        String fileFrom = resource.getFile ();
 //       try {
            File filename = new File(fileFrom);
           // filename.exists();
            System.out.println(filename.exists());
            FileInputStream fis = new FileInputStream(filename);//читающий поток
            DataInputStream ods = new DataInputStream(fis);
            int size = fis.available();
//
           char Array[] = new char[size];
           for (int i = 0; i < size; i++) {
               if (fis.read() != -1) {
                   Array[i] = ods.readChar();
                   System.out.println(Array[i]);
               }
           }
           fis.close();
//
//            FileOutputStream os = new FileOutputStream("SonRec.txt");
//            DataOutputStream od = new DataOutputStream(os);
//            for (int i = 0; i < size; i++) {
//                if (Array[i] == ' ') {
//                    Array[i + 1] = Character.toUpperCase(Array[i + 1]);
//                }
//                od.writeChar(Array[i]);
//            }
//
//            os.close();
 //       }

    }
}




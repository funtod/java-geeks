package com.hillel.elementary.javageeks.artem.homework7;

import java.io.*;

public class NumbersInARow {

    public static byte[] readFile(String path) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer,0,buffer.length);

        return buffer;
    }


    public static int findNumbersInARow(byte[] buffer){
        int counter = 0, resultQuantity = 0;
        String text = new String(buffer);
        for (int i = 0; i < text.length(); i++) {
            Boolean isNum;
            String ch = text.substring(i,i+1);
            try{
                int number = Integer.parseInt(ch);
                isNum = true;
            }catch (Exception exception){
                isNum = false;
            }

            if(isNum == true){
                counter++;
            }else {
                if (resultQuantity <= counter){
                    resultQuantity = counter;
                }
                counter = 0;
            }
        }

        if (counter>0 && resultQuantity == 0){
            resultQuantity = counter;
        }

        return resultQuantity;
    }
}
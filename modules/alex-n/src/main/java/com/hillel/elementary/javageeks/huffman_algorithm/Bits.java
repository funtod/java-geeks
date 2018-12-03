package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.Arrays;

public class Bits {

    public static byte[] binaryStringToByteArray(String bitsString) {
        byte[] bytes = new byte[bitsString.length() / 8 + 1];
        for (int i = 0; i < bytes.length; i++) {
            if (i * 7 + 7 < bitsString.length()) {
                bytes[i] = Byte.parseByte("0" + bitsString.substring(i * 7, i * 7 + 7) ,2);
            }
        }
        return bytes;
    }

    public static  String byteArrayToBinaryString(byte[] bytes){
        System.out.println(Arrays.toString(bytes));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(String.format("%7s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0'));
        }
        return stringBuilder.toString();
    }
}

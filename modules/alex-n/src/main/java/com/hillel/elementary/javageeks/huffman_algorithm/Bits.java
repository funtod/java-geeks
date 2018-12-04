package com.hillel.elementary.javageeks.huffman_algorithm;


public class Bits {

    /*last byte represent a number of empty bits in the end of a sequence*/
    public static byte[] binaryStringToByteArray(String bitsString) {
        byte[] bytes = new byte[bitsString.length() / 7 + 2];
        for (int i = 0; i < bytes.length - 1; i++) {
            if (i * 7 + 7 < bitsString.length()) {
                bytes[i] = Byte.parseByte("0" + bitsString.substring(i * 7, i * 7 + 7) ,2);
            } else {
                bytes[i] = Byte.parseByte("0" + bitsString.substring(i * 7) ,2);
            }
        }
        bytes[bytes.length-1] = (byte)(7 - bitsString.length() % 7);
        return bytes;
    }

    public static String byteArrayToBinaryString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        byte emptyBits = bytes[bytes.length-1];
        for (int i = 0; i < bytes.length - 2; i++) {
            stringBuilder.append(String.format("%7s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0'));
        }
        if (emptyBits < 7) {
            stringBuilder.append(String.format("%" + (7 - emptyBits) + "s",
                    Integer.toBinaryString(bytes[bytes.length - 2] & 0xFF)).replace(' ', '0'));
        }
        return stringBuilder.toString();
    }
}

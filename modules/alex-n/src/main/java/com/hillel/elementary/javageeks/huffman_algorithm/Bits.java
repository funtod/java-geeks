package com.hillel.elementary.javageeks.huffman_algorithm;

final class Bits {

    private static final int BITS_IN_BYTE = 7;
    private static final int EXTRA_BYTES = 2;
    private static final int RADIX = 2;
    private static final int MASK = 0xFF;

    private Bits() {
    }

    /*last byte represent a number of empty bits in the end of a sequence*/
    static byte[] binaryStringToByteArray(String bitsString) {
        byte[] bytes = new byte[bitsString.length() / BITS_IN_BYTE + EXTRA_BYTES];
        for (int i = 0; i < bytes.length - 1; i++) {
            if (i * BITS_IN_BYTE + BITS_IN_BYTE < bitsString.length()) {
                int beginIndex = i * BITS_IN_BYTE;
                bytes[i] = Byte.parseByte("0" + bitsString.substring(beginIndex, beginIndex + BITS_IN_BYTE), 2);
            } else {
                bytes[i] = Byte.parseByte("0" + bitsString.substring(i * BITS_IN_BYTE), RADIX);
            }
        }
        bytes[bytes.length - 1] = (byte) (BITS_IN_BYTE - bitsString.length() % BITS_IN_BYTE);
        return bytes;
    }

    static String byteArrayToBinaryString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        byte emptyBits = bytes[bytes.length - 1];
        for (int i = 0; i < bytes.length - EXTRA_BYTES; i++) {
            stringBuilder.append(String.format("%7s", Integer.toBinaryString(bytes[i] & MASK)).replace(' ', '0'));
        }
        if (emptyBits < BITS_IN_BYTE) {
            stringBuilder.append(String.format("%" + (BITS_IN_BYTE - emptyBits) + "s",
                    Integer.toBinaryString(bytes[bytes.length - EXTRA_BYTES] & MASK)).replace(' ', '0'));
        }
        return stringBuilder.toString();
    }
}

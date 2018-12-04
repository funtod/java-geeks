package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.HashMap;

import static com.hillel.elementary.javageeks.huffman_algorithm.Bits.*;
import static com.hillel.elementary.javageeks.huffman_algorithm.Bits.binaryStringToByteArray;
import static com.hillel.elementary.javageeks.huffman_algorithm.FileReaderWriter.*;
import static com.hillel.elementary.javageeks.huffman_algorithm.HuffmanCodding.*;

public class FileCompressor {

    public static final void compress(String inputFilePath, String outputFilePath, String keyPath) {

        String fileText = readStringFromFile(inputFilePath);
        HashMap<Character, String> codesForCharsInText = getCodesForCharsInText(fileText);
        String encodedStr = encodeText(codesForCharsInText, fileText);
        byte[] bytes = binaryStringToByteArray(encodedStr);
        writeByteArrayToFile(outputFilePath, bytes);
        writeHashMapToFile(keyPath, codesForCharsInText);
    }

    public static final void decompress(String compressedFilePath, String keyFilePath, String decompressedFilePath) {

        HashMap<Character, String> codesForChars = readHashMapFromFile(keyFilePath);
        byte[] bytes = readByteArrayFromFile(compressedFilePath);
        String bits = byteArrayToBinaryString(bytes);
        String decodedText = decode(bits, codesForChars);
        writeStringToFile(decodedText, decompressedFilePath);
    }
}

package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.HashMap;

import static com.hillel.elementary.javageeks.huffman_algorithm.FileReaderWriter.*;
import static com.hillel.elementary.javageeks.huffman_algorithm.HuffmanCodding.*;

public class FileCompressor {

    public static final void compress(String inputFilePath, String outputFilePath, String keyPath) {

        String fileText = readStringFromFile(inputFilePath);
        HashMap<Character, String> codesForCharsInText = getCodesForCharsInText(fileText);
        String encodedStr = encodeText(codesForCharsInText, fileText);
        byte[] bytes = Bits.binaryStringToByteArray(encodedStr);
        writeByteArrayToFile(outputFilePath, bytes);
        writeHashMapToFile(keyPath, codesForCharsInText);
    }

    public static final void decompress(String compressedFilePath, String keyFilePath, String decompressedFilePath) {

        HashMap<Character, String> codesForChars = FileReaderWriter.readHashMapFromFile(keyFilePath);
        byte[] bytes = readBytesFromFile(compressedFilePath);
        String bits = Bits.byteArrayToBinaryString(bytes);
        String decodedText = decode(bits, codesForChars);
        writeStringToFile(decodedText, decompressedFilePath);

    }


}

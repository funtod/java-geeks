package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.HashMap;

final class FileCompressor {

    private FileCompressor() {
    }

    static void compress(String inputFilePath, String outputFilePath, String keyPath) {

        String fileText = FileReaderWriter.readStringFromFile(inputFilePath);
        HashMap<Character, String> codesForCharsInText = HuffmanCodding.getCodesForCharsInText(fileText);
        String encodedStr = HuffmanCodding.encodeText(codesForCharsInText, fileText);
        byte[] bytes = Bits.binaryStringToByteArray(encodedStr);
        FileReaderWriter.writeByteArrayToFile(outputFilePath, bytes);
        FileReaderWriter.writeHashMapToFile(keyPath, codesForCharsInText);
    }

    static void decompress(String compressedFilePath, String keyFilePath, String decompressedFilePath) {

        HashMap<Character, String> codesForChars = FileReaderWriter.readHashMapFromFile(keyFilePath);
        byte[] bytes = FileReaderWriter.readByteArrayFromFile(compressedFilePath);
        String bits = Bits.byteArrayToBinaryString(bytes);
        String decodedText = HuffmanCodding.decode(bits, codesForChars);
        FileReaderWriter.writeStringToFile(decodedText, decompressedFilePath);
    }
}

package com.hillel.elementary.javageeks.huffman_algorithm;

public class TextComperrsor {

    public static HuffmanCodedData[] compress (String text) {
        String[] word = text.split("\\s");
        HuffmanCodedData[] codedData = new HuffmanCodedData[text.length()];

        for (int i = 0; i < word.length; i++) {
            codedData[i] = HuffmanCodding.encode(word[i]);
        }
        return codedData;
    }

    public static HuffmanCodedData[] decompress (String text) {
        return null;
        //TODO realize
    }
}

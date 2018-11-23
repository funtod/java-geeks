package com.hillel.elementary.javageeks.huffman_algorithm;

public class TextCompressor {

    public final String compress(String text) {
        if (text == null || text.trim().isEmpty()) {
            return text;
        }

        String[] words = text.split("\\s");
        String resultCode = "";
        for (int i = 0; i < words.length; i++) {
            resultCode = resultCode + new HuffmanCodding().encode(words[i]);
            if (i != words.length - 1) {
                resultCode += "\n";
            }
        }
        return resultCode;
    }
}

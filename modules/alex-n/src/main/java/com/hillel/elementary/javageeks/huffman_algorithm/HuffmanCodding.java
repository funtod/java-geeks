package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.*;

final class HuffmanCodding {

    private HuffmanCodding() {
    }

    private static class HuffmanNode {
        private int value;
        private Character later;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency, Character character, HuffmanNode leftNode, HuffmanNode rightNode) {
            this.value = frequency;
            this.later = character;
            this.left = leftNode;
            this.right = rightNode;
        }
    }

    static HashMap<Character, String> getCodesForCharsInText(String text) {

        HashMap<Character, Integer> charsFrequencyMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer val = charsFrequencyMap.get(c);
            if (val != null) {
                charsFrequencyMap.put(c, val + 1);
            } else {
                charsFrequencyMap.put(c, 1);
            }
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new HuffmanComparator());
        Object[] chars = charsFrequencyMap.entrySet().toArray();

        for (Object aChar : chars) {
            char currentChar = aChar.toString().charAt(0);
            HuffmanNode huffmanNode = new HuffmanNode(charsFrequencyMap.get(currentChar), currentChar, null, null);
            queue.add(huffmanNode);
        }

        HuffmanNode root = null;

        while (queue.size() > 1) {
            HuffmanNode firstMin = queue.poll();
            HuffmanNode secondMin = queue.poll();
            int sum = firstMin.value + secondMin.value;
            HuffmanNode newNode = new HuffmanNode(sum, null, firstMin, secondMin);
            root = newNode;
            queue.add(newNode);
        }

        HashMap<Character, String> codes = new HashMap<>();
        processCodes(root, "", codes);
        return codes;
    }

    private static void processCodes(HuffmanNode root, String code, HashMap<Character, String> prefixes) {
        if (root.left == null && root.right == null && root.later != null) {
            prefixes.put(root.later, code);
            return;
        }
        processCodes(root.left, code + "0", prefixes);
        processCodes(root.right, code + "1", prefixes);
    }

    public static String encodeText(HashMap<Character, String> codes, String txt) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < txt.length(); i++) {
            str.append(codes.get(txt.charAt(i)));
        }
        return str.toString();
    }

    public static String decode(String bits, HashMap<Character, String> charCodes) {
        StringBuilder stringBuilder = new StringBuilder(bits);
        Character[] characters = new Character[charCodes.keySet().size()];
        charCodes.keySet().toArray(characters);

        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = 0; j < characters.length; j++) {
                if (stringBuilder.indexOf(charCodes.get(characters[j])) == i) {
                    stringBuilder.replace(i, i + charCodes.get(characters[j]).length(), String.valueOf(characters[j]));
                }
            }
        }
        return stringBuilder.toString();
    }

    static class HuffmanComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            return node1.value - node2.value;
        }
    }
}

package com.hillel.elementary.javageeks.huffman_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCodding {

    private class HuffmanNode {
        private int value;
        private char later;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency, char character, HuffmanNode leftNode, HuffmanNode rightNode) {
            this.value = frequency;
            this.later = character;
            this.left = leftNode;
            this.right = rightNode;
        }
    }

    public final String encode(String word) {
        if (word.length() == 1) {
            return word + ":0";
        }

        HashMap<Character, Integer> charsFrequencyMap = new HashMap<Character, Integer>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer val = charsFrequencyMap.get(c);
            if (val != null) {
                charsFrequencyMap.put(c, new Integer(val + 1));
            } else {
                charsFrequencyMap.put(c, 1);
            }
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new HuffmanComparator());

        Object[] chars =  charsFrequencyMap.entrySet().toArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i].toString().charAt(0);
            HuffmanNode huffmanNode = new HuffmanNode(charsFrequencyMap.get(currentChar), currentChar, null, null);
            queue.add(huffmanNode);
        }

        HuffmanNode root = null;

        while (queue.size() > 1) {

            HuffmanNode firstMin = queue.peek();
            queue.poll();
            HuffmanNode secondMin = queue.peek();
            queue.poll();

            int sum = firstMin.value + secondMin.value;
            HuffmanNode newNode = new HuffmanNode(sum, '-', firstMin, secondMin);
            root = newNode;
            queue.add(newNode);
        }

        ArrayList<String> codes = new ArrayList<>();
        getCode(root, "", codes);

        String resultCodes = "";
        for (int i = 0; i < codes.size(); i++) {
            resultCodes = resultCodes + codes.get(i);
            if (i != codes.size() - 1) {
                resultCodes += " ";
            }
        }

        return resultCodes;
    }

    private void getCode(HuffmanNode root, String code, ArrayList<String> codes) {
        if (root.left == null && root.right == null && Character.isLetter(root.later)) {
             codes.add(root.later + ":" + code);
             return;
        }
        getCode(root.left, code + "0", codes);
        getCode(root.right, code + "1", codes);
    }

    class HuffmanComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            return node1.value - node2.value;
        }
    }
}

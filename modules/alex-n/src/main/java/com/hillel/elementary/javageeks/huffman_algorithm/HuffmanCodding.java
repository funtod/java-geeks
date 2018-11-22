package com.hillel.elementary.javageeks.huffman_algorithm;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCodding {

    public static HuffmanCodedData encode(String word) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int iterations = word.length();

        for (int i = 0; i < iterations; i++) {
            char c = word.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            }
            else {
                map.put(c, 1);
            }
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Object[] chars =  map.entrySet().toArray();
        for (int i = 0; i < iterations ; i++) {
            char currentChar = chars[i].toString().charAt(0);
            HuffmanNode huffmanNode = new HuffmanNode(map.get(currentChar), currentChar, null, null);
            queue.add(huffmanNode);
        }


        HuffmanNode root = null;

        while (queue.size() > 1){

            HuffmanNode firstMin = queue.peek();
            queue.poll();

            HuffmanNode secondMin = queue.peek();
            queue.poll();

            int sum = firstMin.getValue() + secondMin.getValue();
            HuffmanNode newNode = new HuffmanNode(sum, '-', firstMin, secondMin);
            root = newNode;
            queue.add(newNode);
        }






        return
    }

    public static String decode(HuffmanCodedData huffmanCodedData) {

    }

    private String getCode(){

    }

}

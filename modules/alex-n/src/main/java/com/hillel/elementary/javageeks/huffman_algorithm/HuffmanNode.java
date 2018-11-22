package com.hillel.elementary.javageeks.huffman_algorithm;

class HuffmanNode {

    private int value;
    private char later;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(int frequency, char character, HuffmanNode leftNode, HuffmanNode rightNode) {
        this.value = frequency;
        this.later = character;
        this.left = leftNode;
        this.right = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int frequency) {
        this.value = value;
    }

    public char getLater() {
        return later;
    }

    public void setLater(char character) {
        this.later = later;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode leftNode) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode rightNode) {
        this.right = right;
    }
}

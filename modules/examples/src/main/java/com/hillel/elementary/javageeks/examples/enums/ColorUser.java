package com.hillel.elementary.javageeks.examples.enums;

public class ColorUser {

    public static void printColor(Color color) {
        Color.BLUE.ordinal();
        System.out.println(color.hex);
    }


    public static void main(String[] args) {
        printColor(Color.GREEN);
    }
}

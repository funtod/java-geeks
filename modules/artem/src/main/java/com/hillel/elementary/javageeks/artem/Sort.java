package com.hillel.elementary.javageeks.artem;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Enter size of array: ");
        size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Array:");
        add(array);
        print(array);
        System.out.println("Array:");
        print(array);
    }

    public static void add(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void sort() {

    }

}

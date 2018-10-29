package com.hillel.elementary.javageeks;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Myarray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        arr[0] = Integer.parseInt(scanner.next());
        arr[1] = Integer.parseInt(scanner.next());
        arr[2] = Integer.parseInt(scanner.next());
        arr[3] = Integer.parseInt(scanner.next());
        arr[4] = Integer.parseInt(scanner.next());

        int sum = 0;
        int average = 0;

        for (int i : arr) {
            sum += i;
        }
        average = sum / 5;

        System.out.print("numbers less average :");
        for (int i : arr) {
            if (i < average) {
                System.out.print(i + ",");
            }
        }
        System.out.println();
            System.out.print("numbers more average :");
            for (int k : arr) {
                if (k > average) {
                    System.out.print(k + ",");
                }
            }


        }
    }


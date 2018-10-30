package com.hillel.elementary.javageeks.mostipan.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n: ");
        int arrayLength = scanner.nextInt();
        int[][] matrix = new int[arrayLength][arrayLength];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random()*(arrayLength+arrayLength)-arrayLength);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(matrix[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("Input column number:");
        int column = (scanner.nextInt()-1);
        int[] tmp = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length-1; j++) {
                if ( matrix[j][column] > matrix[j+1][column]){
                    for (int k = 0; k < matrix.length; k++) {
                        tmp[k] = matrix[j+1][k];
                        matrix[j+1][k] = matrix[j][k];
                        matrix[j][k] = tmp[k];
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
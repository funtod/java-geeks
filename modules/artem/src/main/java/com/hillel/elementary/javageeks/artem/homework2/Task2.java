package com.hillel.elementary.javageeks.artem.homework2;

import java.util.Scanner;

public class Task2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int rows, columns, sum = 0, rowone, colone, rowtwo, coltwo;

        System.out.print("Enter quantity of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter quantity of columns: ");
        columns = scanner.nextInt();

        int[][] array = new int[rows][columns];
        add(array);
        printArray(array);
        System.out.println("Enter the coordinates of the upper left border");
        System.out.print("row: ");
        rowone = scanner.nextInt();
        System.out.print("column: ");
        colone = scanner.nextInt();

        System.out.println();

        System.out.println("Enter the coordinates of the lower right border");
        System.out.print("row: ");
        rowtwo = scanner.nextInt();
        System.out.print("column: ");
        coltwo = scanner.nextInt();



        if(rowone<0 || colone<0 || rowtwo<0 || coltwo<0 || rowone>=columns || colone>=rows || rowtwo>=columns || coltwo>=rows){
            System.out.println("Error in coordinates! Try again");
        }else{
            for (int i = rowone; i <= rowtwo; i++) {
                for (int j = colone; j <= coltwo; j++) {
                sum += array[i][j];
                }
            }

        System.out.println("\nSum = "+sum);
        }
    }
    
    public static void add(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            array[i][j] = (int)(Math.random()*100);
            }
        }
    }

    public static void printArray(int[][] array){
        System.out.println("\nArray:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

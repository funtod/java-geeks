package com.hillel.elementary.javageeks.cellular_automaton;

import java.util.Scanner;

import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.*;

public class Main {
    public static void main(String[] args){

        int rows = 0;
        int columns = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.printf("please enter number of columns: ");
        if (scanner.hasNextInt()) {
            columns = scanner.nextInt();
        }else {
            System.out.printf("wrong data. Exit");
            System.exit(0);
        }
        System.out.printf("Please enter number of rows: ");
        if (scanner.hasNextInt()) {
            rows = scanner.nextInt();
        }else {
            System.out.printf("wrong data. Exit");
            System.exit(0);
        }

        int[][] matrix = new int[rows][columns];

        matrix = fillMatrix(matrix);
        System.out.println("Initialized matrix:");
        printMatrix(matrix);

        matrix = oneLifeCycle(matrix);
        System.out.println("Matrix after one life cycle:");
        printMatrix(matrix);
    }
}


class MatrixProcessor{

    //fill matrix with random 0 or 1
    public static int[][] fillMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random());
            }
        }
        return matrix;
    }

    //process one life cycle of a matrix
    public static int[][] oneLifeCycle(int[][] matrix){

        int columnsNumber = matrix.length;
        int rowsNumber = matrix[0].length;
        int[][] afterOneCycleMatrix = new int[rowsNumber][columnsNumber];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                int neighbours = 0;

                if (i > 0 && j > 0) {                            //upper left corner
                    neighbours += matrix[i - 1][j - 1];
                }

                if (j > 0) {                                     //upper edge
                    neighbours += matrix[i][j - 1];
                }

                if (i < columnsNumber - 1 && j > 0) {            //upper right corner
                    neighbours += matrix[i + 1][j - 1];
                }

                if (i > 0) {                                     //left edge
                    neighbours += matrix[i - 1][j];
                }

                if (i < columnsNumber - 1) {                     //right edge
                    neighbours += matrix[i + 1][j];
                }

                if (i > 0 && j < rowsNumber - 1) {               //bottom left corner
                    neighbours += matrix[i - 1][j + 1];
                }

                if (j < rowsNumber - 1) {                        //bottom edge
                    neighbours += matrix[i][j + 1];
                }

                if (i < columnsNumber - 1 && j < rowsNumber - 1) { //bottom right corner
                    neighbours += matrix[i+1][j+1];
                }


                if (matrix[i][j]==1){
                    if (neighbours > 3 || neighbours < 2){
                        afterOneCycleMatrix[i][j] = 0;
                    }else {
                        afterOneCycleMatrix[i][j] = 1;
                    }
                }else {
                    if(neighbours == 3){
                        afterOneCycleMatrix[i][j] = 1;
                    }
                }
            }
        }
        return afterOneCycleMatrix;
    }


    public static void printMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(String.valueOf(matrix[i][j]) + " ");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
}
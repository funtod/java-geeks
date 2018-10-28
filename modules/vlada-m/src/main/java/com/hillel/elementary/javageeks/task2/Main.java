package com.hillel.elementary.javageeks.task2;
/*
Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.

Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter an integer to specify the size of matrix: ");
        int matrixSize = getIntFromClient(scanner);

        int[][] m = new int[matrixSize][matrixSize];
        generateMatrix(m, matrixSize);
        printMatrix(m);

        System.out.println("Please, enter an integer to specify the number of shifts for matrix");
        int shiftTimes = getIntFromClient(scanner);

        int[][] shiftedLeftMatrix = copyMatrix(m);
        int[][] shiftedDownMatrix = copyMatrix(m);
        int[][] shiftedRightMatrix = copyMatrix(m);
        int[][] shiftedUpMatrix = copyMatrix(m);

        for (int i = 0; i < shiftTimes; i++) {
            shiftLeft(shiftedLeftMatrix);
            shiftDown(shiftedDownMatrix);
            shiftRight(shiftedRightMatrix);
            shiftUp(shiftedUpMatrix);
        }
        System.out.println("Generated matrix was shifted left "+shiftTimes+" times");
        printMatrix(shiftedLeftMatrix);
        System.out.println("Generated matrix was shifted down "+shiftTimes+" times");
        printMatrix(shiftedDownMatrix);
        System.out.println("Generated matrix was shifted right "+shiftTimes+" times");
        printMatrix(shiftedRightMatrix);
        System.out.println("Generated matrix was shifted up "+shiftTimes+" times");
        printMatrix(shiftedUpMatrix);
    }

    private static int getIntFromClient(Scanner scanner) {
        int intToGet = 0;
        try {
            intToGet = scanner.nextInt();
            if (intToGet <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry, you input not an integer. The program will be closed...");
            System.exit(-1);
        } catch (IllegalArgumentException exception) {
            System.out.println("Sorry, the integer should be greater than 0. The program will be closed...");
            System.exit(-1);
        }
        return intToGet;
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] copyMatrix(int[][] m) {
        int[][] copiedMatrix = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                copiedMatrix[i][j] = m[i][j];
            }
        }
        return copiedMatrix;
    }

    public static void shiftLeft(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int columnCount = m[i].length;
            for (int j = columnCount - 1; j > 0; j--) {
                int temp = m[i][j - 1];
                m[i][j - 1] = m[i][columnCount - 1];
                m[i][columnCount - 1] = temp;
            }
        }
    }


    public static void shiftDown(int[][] m) {
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int temp = m[0][j];
                m[0][j] = m[i + 1][j];
                m[i + 1][j] = temp;
            }
        }
    }

    public static void shiftUp(int[][] m) {
        for (int rowIndex = m.length; rowIndex > 1; rowIndex--) {
            for (int columnIndex = 0; columnIndex < m[0].length; columnIndex++) {
                int temp = m[0][columnIndex];
                m[0][columnIndex] = m[rowIndex - 1][columnIndex];
                m[rowIndex - 1][columnIndex] = temp;
            }
        }

    }

    public static void shiftRight(int[][] m) {
        for (int rowIndex = 0; rowIndex < m.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < m[rowIndex].length - 1; columnIndex++) {
                int temp = m[rowIndex][0];
                m[rowIndex][0] = m[rowIndex][columnIndex + 1];
                m[rowIndex][columnIndex + 1] = temp;
            }
        }

    }

    private static void generateMatrix(int[][] matrixToGenerate, int rangeOfNumbers) {
        Random generator = new Random();
        for (int i = 0; i < matrixToGenerate.length; i++) {
            for (int j = 0; j < matrixToGenerate[i].length; j++) {
                boolean isPositiveNumber = generator.nextBoolean();
                int gn = generator.nextInt(rangeOfNumbers);
                if (isPositiveNumber) {
                    matrixToGenerate[i][j] = gn;
                } else {
                    matrixToGenerate[i][j] = -gn;
                }

            }
        }
    }
}



package com.hillel.elementary.javageeks.cellular_automaton;

import java.util.Scanner;

import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.fillMatrix;
import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.oneLifeCycle;
import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.printMatrix;

public final class CellularAutomaton {

    private CellularAutomaton() { }

    public static int[][] getUserMatrixDimensions() {
        int rows = 0;
        int columns = 0;
        Scanner scanner = new Scanner(System.in);
        boolean initializingData = true;

        while (initializingData) {
            System.out.printf("Please enter number of columns: ");
            if (scanner.hasNextInt()) {
                columns = scanner.nextInt();
            } else {
                System.out.printf("wrong data. Exit");
                System.exit(1);
            }
            System.out.printf("Please enter number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
            } else {
                System.out.printf("wrong data. Exit");
                System.exit(1);
            }
            if (columns <= 0 || rows <= 0) {
                System.out.println("Error. Can't sat matrix: " + columns + " x "
                        + rows + ". Dimensions must be grater than 0. Try again.");
                initializingData = true;
            } else {
                initializingData = false;
            }
        }

        int[][] matrix = new int[columns][rows];

        return matrix;
    }

    public static void run() {
        int[][] matrix = getUserMatrixDimensions();

        matrix = fillMatrix(matrix);
        System.out.println("Initialized matrix:");
        printMatrix(matrix);

        matrix = oneLifeCycle(matrix);
        System.out.println("Matrix after one life cycle:");
        printMatrix(matrix);
    }
}

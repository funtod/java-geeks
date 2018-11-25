package com.hillel.elementary.javageeks.cellular_automaton;

public final class MatrixProcessor {
    public static final int MAX_NEIGHBOURS_TO_STAY_ALIVE = 3;
    public static final int MIN_NEIGHBOURS_TO_STAY_ALIVE = 2;
    public static final int NEIGHBOURS_TO_BORN_NEW_LIFE = 3;

    private MatrixProcessor() {
    }

    //fill matrix with random 0 or 1
    public static int[][] fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = (int) Math.round(Math.random());
            }
        }
        return matrix;
    }

    //process one life cycle of a matrix
    public static int[][] oneLifeCycle(int[][] matrix) {
        int columnsNumber = matrix.length;
        int rowsNumber = matrix[0].length;
        int[][] afterOneCycleMatrix = new int[columnsNumber][rowsNumber];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int neighbours = 0;

                if (j > 0 && i > 0) {                            //upper left corner
                    neighbours += matrix[j - 1][i - 1];
                }

                if (i > 0) {                                     //upper edge
                    neighbours += matrix[j][i - 1];
                }

                if (j < columnsNumber - 1 && i > 0) {            //upper right corner
                    neighbours += matrix[j + 1][i - 1];
                }

                if (j > 0) {                                     //left edge
                    neighbours += matrix[j - 1][i];
                }

                if (j < columnsNumber - 1) {                     //right edge
                    neighbours += matrix[j + 1][i];
                }

                if (j > 0 && i < rowsNumber - 1) {               //bottom left corner
                    neighbours += matrix[j - 1][i + 1];
                }

                if (i < rowsNumber - 1) {                        //bottom edge
                    neighbours += matrix[j][i + 1];
                }

                if (j < columnsNumber - 1 && i < rowsNumber - 1) { //bottom right corner
                    neighbours += matrix[j + 1][i + 1];
                }


                if (matrix[j][i] == 1) {
                    if (neighbours > MAX_NEIGHBOURS_TO_STAY_ALIVE || neighbours < MIN_NEIGHBOURS_TO_STAY_ALIVE) {
                        afterOneCycleMatrix[j][i] = 0;
                    } else {
                        afterOneCycleMatrix[j][i] = 1;
                    }
                } else {
                    if (neighbours == NEIGHBOURS_TO_BORN_NEW_LIFE) {
                        afterOneCycleMatrix[j][i] = 1;
                    }
                }
            }
        }
        return afterOneCycleMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf(String.valueOf(matrix[j][i]));
                if (j != matrix.length - 1) {
                    System.out.printf(" ");
                }
            }
            if (i != matrix[0].length - 1) {
                System.out.printf("\n");
            }
        }
    }
}

package com.hillel.elementary.javageeks.examples.threads.concurrent.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MatrixFJ extends RecursiveAction {
    private static final long serialVersionUID = -5406471649271521322L;
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultingMatrix;
    private int row;

    public MatrixFJ(int[][] firstMatrix, int[][] secondMatrix, int[][] resultingMatrix) {
        this(firstMatrix, secondMatrix, resultingMatrix, -1);
    }

    private MatrixFJ(int[][] firstMatrix, int[][] secondMatrix, int[][] resultingMatrix, int row) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("rows/columns mismatch");
        }
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultingMatrix = resultingMatrix;
        this.row = row;
    }

    @Override
    public void compute() {
        if (row == -1) {
            List<MatrixFJ> tasks = new ArrayList<>();
            for (int row = 0; row < firstMatrix.length; row++) {
                tasks.add(new MatrixFJ(firstMatrix, secondMatrix, resultingMatrix, row));
            }
            invokeAll(tasks);
        } else {
            multiplyRowByColumn(firstMatrix, secondMatrix, resultingMatrix, row);
        }
    }

    void multiplyRowByColumn(int[][] a, int[][] b, int[][] c, int row) {
        for (int j = 0; j < b[0].length; j++) {
            for (int k = 0; k < a[0].length; k++) {
                c[row][j] = c[row][j] + a[row][k] * b[k][j];
            }
        }
    }
}
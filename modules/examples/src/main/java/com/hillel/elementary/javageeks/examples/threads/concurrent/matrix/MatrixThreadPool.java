package com.hillel.elementary.javageeks.examples.threads.concurrent.matrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixThreadPool implements Runnable {
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultingMatrix;
    private int row;

    public MatrixThreadPool(int[][] firstMatrix, int[][] secondMatrix) {
        this(firstMatrix, secondMatrix, new int[firstMatrix.length][secondMatrix[0].length], -1);
    }

    private MatrixThreadPool(int[][] firstMatrix, int[][] secondMatrix, int[][] resultingMatrix, int row) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("rows/columns mismatch");
        }
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultingMatrix = resultingMatrix;
        this.row = row;
    }

    public int[][] calculate() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int row = 0; row < firstMatrix.length; row++) {
            executor.submit(new MatrixThreadPool(firstMatrix, secondMatrix, resultingMatrix, row));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        return resultingMatrix;
    }

    @Override
    public void run() {
        multiplyRowByColumn(firstMatrix, secondMatrix, resultingMatrix, row);
    }

    private void multiplyRowByColumn(int[][] a, int[][] b, int[][] c, int row) {
        for (int j = 0; j < b[0].length; j++) {
            for (int k = 0; k < a[0].length; k++) {
                c[row][j] = c[row][j] + a[row][k] * b[k][j];
            }
        }
    }
}
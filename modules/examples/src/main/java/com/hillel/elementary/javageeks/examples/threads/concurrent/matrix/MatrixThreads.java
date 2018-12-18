package com.hillel.elementary.javageeks.examples.threads.concurrent.matrix;

public class MatrixThreads implements Runnable {
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultingMatrix;
    private int[] row;

    public MatrixThreads(int[][] firstMatrix, int[][] secondMatrix) {
        this(firstMatrix, secondMatrix, new int[firstMatrix.length][secondMatrix[0].length], -1);
    }

    private MatrixThreads(int[][] firstMatrix, int[][] secondMatrix, int[][] resultingMatrix, int... row) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("rows/columns mismatch");
        }
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultingMatrix = resultingMatrix;
        this.row = row;
    }

    public int[][] calculate() throws InterruptedException {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberOfThreads];

        int threadCount = 0;
        for (int row = 0; row < firstMatrix.length; row++) {
            Thread t = new Thread(new MatrixThreads(firstMatrix, secondMatrix, resultingMatrix, row));
            if (threadCount >= numberOfThreads) {
                threadCount = 0;
                threads[threadCount].join();
                threads[threadCount] = t;
            } else if (threads[threadCount] != null) {
                threads[threadCount].join();
                threads[threadCount] = t;
            } else {
                threads[row] = t;
            }
            threadCount++;
            t.start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            if (threads[i] != null)
                threads[i].join();
        }

        return resultingMatrix;
    }

    @Override
    public void run() {
        multiplyRowByColumn(firstMatrix, secondMatrix, resultingMatrix, row);
    }

    private void multiplyRowByColumn(int[][] a, int[][] b, int[][] c, int... row) {
        for (Integer r : row) {
            for (int i = 0; i < b[0].length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    c[r][i] = c[r][i] + a[r][j] * b[j][i];
                }
            }
        }
    }
}
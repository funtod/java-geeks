package com.hillel.elementary.javageeks.largest_square_search;

public class BinaryMatrix {

    private int[][] binaryMatrix;

    public BinaryMatrix(int[][] inputBinaryMatrix) {
        this.binaryMatrix = inputBinaryMatrix;
    }

    public final int getLargestSquareSize(int num) {
        int largestSquare = 0;
        int matrixLength = binaryMatrix.length;
        int matrixHeight = binaryMatrix[0].length;

        //go through the whole matrix
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixLength; j++) {
                //create sub matrices
                if (binaryMatrix[j][i] == num) {
                    int subMatrixLength = 1;
                    for (int k = 1; k <= subMatrixLength; k++) {
                        int[][] tmpArray = new int[k][k];
                        //fill sub matrices
                        for (int l = 0; l < tmpArray[0].length; l++) {
                            for (int m = 0; m < tmpArray.length; m++) {
                                tmpArray[m][l] = binaryMatrix[j + m][l + i];
                            }
                        }
                        if (isThisMatrixFilledBy(num, tmpArray) & largestSquare <= subMatrixLength * subMatrixLength) {
                            largestSquare = subMatrixLength * subMatrixLength;
                            if (subMatrixLength < matrixLength - j & subMatrixLength < matrixHeight - i) {
                                subMatrixLength++;
                            }
                        }
                    }
                }
            }
        }
        return largestSquare;
    }

    private boolean isThisMatrixFilledBy(int num, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[j][i] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}

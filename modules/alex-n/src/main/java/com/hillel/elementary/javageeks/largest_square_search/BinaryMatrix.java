package com.hillel.elementary.javageeks.largest_square_search;

public class BinaryMatrix {

    int[][] binaryMatrix;

    public void createMatrix(int width, int height){
        binaryMatrix = new int[width][height];
    }

    public void fillMatrix(){
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[0].length; j++) {
                binaryMatrix[j][i] = (int) Math.round(Math.random());
            }
        }
    }

    public int getLargestSquareSize(int num) {
        int largestSquare = 0;
        //go through the whole matrix
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[0].length; j++) {
                //create sub matrixes
                if(binaryMatrix[j][i] == num) {
                    int subMatrixLength = 1;
                    //int subMatrixLength = Math.min(binaryMatrix.length - j, binaryMatrix[0].length - i);
                    for (int k = 0; k < subMatrixLength; k++) {
                        int[][] tmpArray = new int[k][k];
                        //fill sub matrixes
                        for (int l = 0; l < tmpArray.length; l++) {
                            for (int m = 0; m < tmpArray[0].length; m++) {
                                tmpArray[m][l] = binaryMatrix[j + m][l + i];
                            }
                        }
                        if (isThisSquareFieldBy(num, tmpArray) & largestSquare < subMatrixLength * 2) {
                            largestSquare = subMatrixLength * 2;
                            if (subMatrixLength < binaryMatrix.length - j & subMatrixLength < binaryMatrix[0].length - i){
                                subMatrixLength ++;
                            }
                        }
                    }
                }
            }
        }
        return largestSquare;
    }

    private boolean isThisSquareFieldBy(int num, int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[j][i] != num){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[0].length; j++) {
                str += binaryMatrix[j][i]+", ";
            }
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        BinaryMatrix bm = new BinaryMatrix();
        bm.createMatrix(10,10);
        bm.fillMatrix();
        System.out.println(bm.toString());
        System.out.println("Result: " + bm.getLargestSquareSize(1));
    }
}

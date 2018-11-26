package com.hillel.elementary.javageeks.largest_square_search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinaryMatrixTest {

    @Test
    void shouldReturnSquare() {
        int[][] matrix = {{1,1,1},
                          {0,1,1},
                          {0,0,0},
                          {0,0,0}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(matrix);
        assertThat(binaryMatrix.getLargestSquareSize(1)).isEqualTo(4);
    }

    @Test
    void shouldReturnZero() {
        int[][] matrix = {{0,0,0},
                          {0,0,0},
                          {0,0,0},
                          {0,0,0}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(matrix);
        assertThat(binaryMatrix.getLargestSquareSize(1)).isEqualTo(0);
    }

    @Test
    void shouldReturnFullyFilledMatrixSquare() {
        int[][] matrix = {{1,1,1},
                         {1,1,1},
                         {1,1,1}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(matrix);
        assertThat(binaryMatrix.getLargestSquareSize(1)).isEqualTo(9);
    }
}
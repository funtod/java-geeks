package com.hillel.elementary.javageeks.examples.threads.concurrent.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixThreadsTest {

    @Test
    void shouldCalculateMatrix() throws InterruptedException {
        int[][] expectedResult = {
                {1992, 2649, 1844, 4761, 1760},
                {1407, 1848, 1565, 3514, 1234},
                {1347, 1833, 850, 2066, 983},
                {3927, 5217, 3876, 7380, 2949},
                {3718, 4991, 2921, 8452, 3271}

        };
        int[][] first = {
                {33, 34, 12},
                {33, 19, 10},
                {12, 14, 17},
                {84, 24, 51},
                {43, 71, 21}
        };

        int[][] second = {
                {10, 11, 34, 55, 12},
                {33, 45, 17, 81, 32},
                {45, 63, 12, 16, 23}
        };


        int[][] c = new MatrixThreads(first, second).calculate();

        assertArrayEquals(c, expectedResult);
    }
}
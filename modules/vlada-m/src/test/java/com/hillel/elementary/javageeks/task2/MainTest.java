package com.hillel.elementary.javageeks.task2;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


    @Test
    void shouldCopyMatrix() {
        int[][] copiedMatrix = Main.copyMatrix(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length - 1; j++) {
                m[i][j] = 0;
            }
        }
        assertEquals(0, m[0][0]);
        assertEquals(0, m[0][1]);
        assertEquals(0, m[1][0]);

        assertEquals(1, copiedMatrix[0][0]);
        assertEquals(2, copiedMatrix[0][1]);
        assertEquals(4, copiedMatrix[1][0]);
    }

    @Test
    void shouldShiftLeft() {
        int[][] copiedMatrix = Main.copyMatrix(m);
        Main.shiftLeft(copiedMatrix);
        assertEquals(2, copiedMatrix[0][0]);
        assertEquals(3, copiedMatrix[0][1]);
        assertEquals(1, copiedMatrix[0][2]);
        assertEquals(5, copiedMatrix[1][0]);
        assertEquals(6, copiedMatrix[1][1]);
        assertEquals(4, copiedMatrix[1][2]);
    }

    @Test
    void shouldShiftDown() {
        int[][] copiedMatrix = Main.copyMatrix(m);
        Main.shiftDown(copiedMatrix);
        assertEquals(7, copiedMatrix[0][0]);
        assertEquals(8, copiedMatrix[0][1]);
        assertEquals(9, copiedMatrix[0][2]);
        assertEquals(1, copiedMatrix[1][0]);
        assertEquals(2, copiedMatrix[1][1]);
        assertEquals(3, copiedMatrix[1][2]);
    }

    @Test
    void shouldShiftUp() {
        int[][] copiedMatrix = Main.copyMatrix(m);
        Main.shiftUp(copiedMatrix);
        assertEquals(4, copiedMatrix[0][0]);
        assertEquals(5, copiedMatrix[0][1]);
        assertEquals(6, copiedMatrix[0][2]);
        assertEquals(7, copiedMatrix[1][0]);
        assertEquals(8, copiedMatrix[1][1]);
        assertEquals(9, copiedMatrix[1][2]);
    }

    @Test
    void shouldShiftRight() {
        int[][] copiedMatrix = Main.copyMatrix(m);
        Main.shiftRight(copiedMatrix);
        assertEquals(3, copiedMatrix[0][0]);
        assertEquals(1, copiedMatrix[0][1]);
        assertEquals(2, copiedMatrix[0][2]);
        assertEquals(6, copiedMatrix[1][0]);
        assertEquals(4, copiedMatrix[1][1]);
        assertEquals(5, copiedMatrix[1][2]);

    }
}
package com.hillel.elementary.javageeks.cellular_automaton;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.oneLifeCycle;
import static com.hillel.elementary.javageeks.cellular_automaton.MatrixProcessor.printMatrix;
import static org.assertj.core.api.Java6Assertions.assertThat;

class MatrixProcessorTest {

    @Test
    void shouldMakeCellZeroIfSurroundedByZeros() {
        int[][] inputMatrix = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] expectedMatrix = {{0,0,0},{0,0,0},{0,0,0}};

        assertThat(oneLifeCycle(inputMatrix)).isEqualTo(expectedMatrix);
    }

    @Test
    void shouldMakeCellOneIfSurroundedByThreeOnes() {
        int[][] inputMatrix = {{0,1,0},{1,1,0},{0,0,0}};
        int[][] expectedMatrix = {{1,1,0},{1,1,0},{0,0,0}};

        assertThat(oneLifeCycle(inputMatrix)).isEqualTo(expectedMatrix);
    }

    @Test
    void shouldMakeCellZeroIfSurroundedByMoreThenThreeOnes() {
        int[][] inputMatrix = {{1,1,0},{0,1,0},{0,1,1}};
        int[][] expectedMatrix = {{1,1,0},{0,0,0},{0,1,1}};

        assertThat(oneLifeCycle(inputMatrix)).isEqualTo(expectedMatrix);
    }

    @Test
    void shouldReturnZeroFilledMatrix() {
        int[][] inputMatrix = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] expectedMatrix = {{0,0,0},{0,0,0},{0,0,0}};

        assertThat(oneLifeCycle(inputMatrix)).isEqualTo(expectedMatrix);
    }

    @Test
    void shouldPrintMatrix() {
        int[][] inputMatrix = {{0,1,0},{0,1,0},{0,1,0}};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        printMatrix(inputMatrix);

        String expectedStr =  "0 0 0\n" +
                "1 1 1\n" +
                "0 0 0";

        assertThat(new String(out.toByteArray())).isEqualTo(expectedStr);
    }
}
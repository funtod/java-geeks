package com.hillel.elementary.oleh.taskJg4;

import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomMatrixTest {

    @Test
    public void matrixSizeTest() {
        RandomMatrix tmp = new RandomMatrix();
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int actual = 4;
        assertEquals(tmp.matrixSize(), actual);
    }

}
package com.hillel.elementary.javageeks.mycollection;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    @Test
    void shouldsumMatrix(){
        int [][] matrixOne = {{0,2,0},{1,0,0},{0,0,3}};
        int [][] matrixTwo = {{0,2,0,1},{1,0,0,2},{0,0,3,0}};
        Integer[] num = {4,2,4};
        assertArrayEquals(num,MyList.actMatrix(matrixOne, matrixTwo,"sum").toArray());
    }
    @Test
    void shouldmultyplyMatrix(){
        int [][] matrixOne = {{0,2,0},{1,0,0},{0,0,3}};
        int [][] matrixTwo = {{0,2,0,1},{1,0,0,2},{0,0,3,0}};
        Integer[] num = {4, 1, 3};
        assertArrayEquals(num,MyList.actMatrix(matrixOne, matrixTwo,"multiply").toArray());
    }

}
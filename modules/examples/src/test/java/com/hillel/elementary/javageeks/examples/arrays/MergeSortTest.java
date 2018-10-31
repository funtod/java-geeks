package com.hillel.elementary.javageeks.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void shouldSortAnArrayOfOne() {
        int[] arrayToSort = new int[]{0};
        int[] expectedArray = new int[]{0};

        MergeSort.sort(arrayToSort);

        assertArrayEquals(expectedArray, arrayToSort);
    }

    @Test
    void shouldSortArrayWithDuplicates() {
        int[] arrayToSort = new int[]{0, 1, 0, 1};
        int[] expectedArray = new int[]{0, 0, 1, 1};

        MergeSort.sort(arrayToSort);

        assertArrayEquals(expectedArray, arrayToSort);
    }

    @Test
    void shouldSortArray() {
        int[] arrayToSort = new int[]{1, 4, 6, 1, 7, 0, 20, 22, 442, 4, 1, 5};
        int[] expectedArray = new int[]{0, 1, 1, 1, 4, 4, 5, 6, 7, 20, 22, 442};

        MergeSort.sort(arrayToSort);

        assertArrayEquals(expectedArray, arrayToSort);
    }

}
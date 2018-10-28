package com.hillel.elementary.javageeks.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InsertionSortTest {

    @Test
    public void shouldReturnEmptyArrayWhenInputEmptyArray() {
        //given
        int[] input = new int[]{};
        int[] expectedResult = new int[]{};

        //given
        InsertionSort.sort(input);

        //then
        assertThat(input).isEqualTo(expectedResult);
    }


    @Test
    public void shouldReturnSortedArrayAsIs() {
        //given
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] expectedResult = new int[]{1, 2, 3, 4, 5};

        //given
        InsertionSort.sort(input);

        //then
        assertThat(input).isEqualTo(expectedResult);
    }

    @Test
    public void shouldSortArrayOfTwo() {
        //given
        int[] input = new int[]{2, 1};
        int[] expectedResult = new int[]{1, 2};

        //given
        InsertionSort.sort(input);

        //then
        assertThat(input).isEqualTo(expectedResult);
    }

    @Test
    public void shouldSortArrayOfMany() {
        //given
        int[] input = new int[]{2, 1, 6, 8, 9, -4, 5};
        int[] expectedResult = new int[]{-4, 1, 2, 5, 6, 8, 9};

        //given
        InsertionSort.sort(input);

        //then
        assertThat(input).isEqualTo(expectedResult);
    }
}
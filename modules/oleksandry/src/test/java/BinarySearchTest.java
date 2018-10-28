package com.hillel.elementary.javageeks.examples.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldReturnMinusOneIfNotFound() {
        //given
        int[] input = new int[]{-2, -1, 1, 7, 10};

        //when
        int result = BinarySearch.find(4, input);

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnMinusOneIfEmptyArray() {
        //given
        int[] input = new int[]{};

        //when
        int result = BinarySearch.find(4, input);

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnMinusOneIfNullIsPassed() {
        //when
        int result = BinarySearch.find(4, null);

        //then
        assertThat(result).isEqualTo(-1);
    }


    @Test
    public void shouldFindElementInArray() {
        //given
        int[] input = new int[]{-2, -1, 1, 7, 10, 11, 12, 13, 15, 17, 18, 19, 20};

        //when
        int result = BinarySearch.find(7, input);

        //then
        assertThat(result).isEqualTo(3);
    }
}

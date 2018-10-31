package com.hillel.elementary.javageeks.dir.homework3.merge_sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {
    @Test
    public void shouldReturnSortedArray() {

        //given
        int[] input = new int[]{6, 5, 4, -9, 1, 13, 7, -7};

        //when
        int[] result = MergeSort.mergeSort(input);

        //then
        int[] sorted = new int[]{-9, -7, 1, 4, 5, 6, 7, 13};
        assertThat(result).isEqualTo(sorted);
    }
}


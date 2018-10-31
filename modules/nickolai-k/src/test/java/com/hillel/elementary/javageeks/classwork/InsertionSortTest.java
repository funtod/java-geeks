package com.hillel.elementary.javageeks.classwork;

import com.hillel.elementary.javageeks.nickolai.classwork.InsertionSort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class InsertionSortTest {

    @Test
    public void shouldReturnSMTHWhenEmptyArray() {
        int[] input = new int[] {};
        int[] expectedOuntput = new int[] {};

        InsertionSort.sort(input);

        assertThat(input).isEqualTo(expectedOuntput);
    }

    @Test
    public void shouldReturnArrayWhenArrayIsSorted() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] expectedOuntput = new int[] {1, 2, 3, 4, 5};

        InsertionSort.sort(input);

        assertThat(input).isEqualTo(expectedOuntput);
    }
//TODO Fix this test
    @Test
    public void shouldSortArrayOfTwo() {
        int[] input = new int[] {2, 3, 4, 5, 1, 7};
        int[] expectedOuntput = new int[] {1, 2, 3, 4, 5, 7};

        InsertionSort.sort(input);

        assertThat(input).isEqualTo(expectedOuntput);
    }
}

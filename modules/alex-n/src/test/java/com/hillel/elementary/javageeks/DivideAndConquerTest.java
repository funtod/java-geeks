package com.hillel.elementary.javageeks;

import com.hillel.elementary.javageeks.divide_and_conquer.Sorter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivideAndConquerTest {

    @Test
    public void shouldReturnEmptyArrayWhenInputEmptyArray() {
        int[] input = new int[]{};
        int[] shouldGet = new int[]{};
        input = Sorter.mergeSort(input);
        assertThat(input).isEqualTo(shouldGet);
    }

    @Test
    void shouldSortArray() {
        int[] input = new int[]{5, 4, 8, 16, 73, -4};
        int[] shouldGet = new int[]{-4, 4, 5, 8, 16, 73};
        assertThat(Sorter.mergeSort(input)).isEqualTo(shouldGet);
    }


    @Test
    void shouldReturnNullIfGetsNull() {
        assertThat(Sorter.mergeSort(null)).isNull();
    }

    @Test
    void shouldDealWithAllElementsZeroArray() {
        int[] input = new int[]{0,0,0,0,0};
        int[] shouldGet = new int[]{0,0,0,0,0};
        assertThat(Sorter.mergeSort(input)).isEqualTo(shouldGet);
    }

    @Test
    void shouldSortArrayOfTwo() {
        int[] input = new int[]{57,-45};
        int[] shouldGet = new int[]{-45,57};
        assertThat(Sorter.mergeSort(input)).isEqualTo(shouldGet);
     }

    @Test
    void shouldReturnOneElementArrayWhenGetsOneElementArray() {
        int[] input = new int[]{1};
        int[] shouldGet = new int[]{1};
        assertThat(Sorter.mergeSort(input)).isEqualTo(shouldGet);
    }
}

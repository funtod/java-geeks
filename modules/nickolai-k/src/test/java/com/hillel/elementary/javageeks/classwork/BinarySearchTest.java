package com.hillel.elementary.javageeks.classwork;

import com.hillel.elementary.javageeks.nickolai.classwork.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldFindElement() {
        int[] input = new int[] {-2, -1, 1, 7, 10};
        int result = BinarySearch.find(10, input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void shouldReturnNullIfNotFound() {
        int result = BinarySearch.find(10, null);
        assertThat(result).isEqualTo(-1);
    }
}

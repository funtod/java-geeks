package com.hillel.elementary.javageeks.ruslanTask7;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SortArrayTest {

        @Test
        public void shouldReturnResult(){

            ArrayList<Integer> arrayList = new ArrayList<>();

            arrayList.add(-12);
            arrayList.add(-1);
            arrayList.add(43);
            arrayList.add(-0);
            arrayList.add(-14);
            arrayList.add(12);
            arrayList.add(212);
            arrayList.add(45);

            SortArray sortArray=new SortArray();

            int min = sortArray.getArray(arrayList).get(0);;
            int max = sortArray.getArray(arrayList).get(arrayList.size()-1);;

            int expectedMin= 212;
            int expectedMax = -14;
            assertThat(min).isEqualTo(expectedMin);
            assertThat(max).isEqualTo(expectedMax);
        }
}

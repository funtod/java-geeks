package com.hillel.elementary.javageeks.examples.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void shouldReturnTrueIfContainsElement() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        //when
        boolean result = list.contains("d");

        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldRemoveNullElement() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        //when
        boolean result = list.remove(null);

        //then
        assertThat(result).isTrue();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void shouldRemoveNonNullElement() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        //when
        boolean result = list.remove("b");

        //then
        assertThat(result).isTrue();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.indexOf(null)).isEqualTo(1);
    }

    @Test
    void shouldReturnFalseIfNothingToDelete() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        //when
        boolean result = list.remove("c");

        //then
        assertThat(result).isFalse();
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    void shouldReturnTrueIfContainsAllElements() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        Collection otherList = new ArrayList();
        list.add("a");
        list.add("d");


        //when
        boolean result = list.containsAll(otherList);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseIfDoesNotContainAllElements() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        Collection otherList = new ArrayList();
        otherList.add("a");
        otherList.add("d");
        otherList.add("T");


        //when
        boolean result = list.containsAll(otherList);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldAddAllElementsFromOtherCollection() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        Collection otherList = new ArrayList();
        otherList.add("n");
        otherList.add("m");
        otherList.add("z");

        MyArrayList expected = new MyArrayList();
        expected.add("a");
        expected.add("n");
        expected.add("m");
        expected.add("z");
        expected.add("b");
        expected.add(null);
        expected.add("d");


        //when
        boolean result = list.addAll(1, otherList);

        //then
        assertThat(result).isTrue();
        assertEquals(expected, list);
    }

    @Test
    void shouldAddAll() {
        //given
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        Collection otherList = new ArrayList();
        otherList.add("n");
        otherList.add("m");
        otherList.add("z");

        MyArrayList expected = new MyArrayList();
        expected.add("a");
        expected.add("n");
        expected.add("m");
        expected.add("z");
        expected.add("b");
        expected.add(null);
        expected.add("d");


        //when
        boolean result = list.addAll(1, otherList);

        //then
        assertThat(result).isTrue();
        assertEquals(expected, list);
    }


}
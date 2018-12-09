package com.hillel.elementary.javageeks.examples.collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyHashTableTest {

    @Test
    void shouldAddElements() {
        MyHashTable table = new MyHashTable();

        table.put("a", "aa");
        table.put("b", "ba");
        table.put("c", "ca");
        table.put("a", "da");


        assertThat(table.size()).isEqualTo(3);
        assertThat(table.get("a")).isEqualTo("da");
    }

    @Test
    void shouldResizeMap() {
        MyHashTable table = new MyHashTable(1);

        table.put("a", "aa");
        table.put("b", "ba");
        table.put("c", "ca");
        table.put("a", "da");


        assertThat(table.size()).isEqualTo(3);
        assertThat(table.get("a")).isEqualTo("da");
    }
}
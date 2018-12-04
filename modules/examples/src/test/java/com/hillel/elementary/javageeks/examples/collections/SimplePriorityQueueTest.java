package com.hillel.elementary.javageeks.examples.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class SimplePriorityQueueTest {

    @Test
    void shouldAddAndRemoveElements(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        SimplePriorityQueue queue = new SimplePriorityQueue(comparator);

        queue.add(4);
        queue.add(2);
        queue.add(6);
        queue.add(3);
        queue.add(7);

        assertThat(queue.poll()).isEqualTo(7);
        assertThat(queue.poll()).isEqualTo(6);
        assertThat(queue.poll()).isEqualTo(4);
        assertThat(queue.poll()).isEqualTo(3);
        assertThat(queue.poll()).isEqualTo(2);

        assertThat(queue.size()).isEqualTo(0);
    }

}
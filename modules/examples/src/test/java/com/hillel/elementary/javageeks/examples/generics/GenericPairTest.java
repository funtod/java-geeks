package com.hillel.elementary.javageeks.examples.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericPairTest {

    @Test
    void name() {

        GenericPair<String, Number> pairOne = new GenericPair<>("sdf", 3);
        Number a = 4;
        GenericPair<?, ? super Integer> pairTwo = new GenericPair<>(4, a);
    }

    public void consumer(GenericPair<Number, Number> pair) {

    }
}
package com.hillel.elementary.javageeks.examples.classes.cloning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCloneTest {

    @Test
    void shouldClone() throws CloneNotSupportedException {
        UseClone useClone = new UseClone(2);
        useClone.push(2);

        UseClone clone = (UseClone) useClone.clone();

        assertEquals(2, clone.pop());
    }
}
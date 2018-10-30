package com.hillel.elementary.javageeks.examples.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorExampleTest {


    @Test
    void something() {

        ConstructorExample example = new ConstructorExample();

        Long longNumber = 10l;
        Integer integer = 12;


        example.someMethod(longNumber);
        example.someMethod(integer);
    }
}
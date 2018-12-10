package com.hillel.elementary.javageeks.examples.generics;

import java.io.Serializable;

public class MultipleBoundsExample {


    class SomeClass<T extends Hero & Comparable<T> & Serializable> {

    }

}

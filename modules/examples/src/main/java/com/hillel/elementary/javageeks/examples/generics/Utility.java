package com.hillel.elementary.javageeks.examples.generics;

import java.util.List;

public class Utility {


    public static <T> T fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);

        return val;
    }

}

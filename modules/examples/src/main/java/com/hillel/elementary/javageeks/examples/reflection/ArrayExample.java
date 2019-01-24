package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        byte[] ba = (byte[]) Array.newInstance(byte.class,13);
        System.out.println(Arrays.toString(ba));

        int[] dims = {4, 4};
        System.out.println(Arrays.toString(dims));

        System.out.println("dims type: " + dims.getClass());
        System.out.println("dims component type: " + dims.getClass().getComponentType());
        System.out.println();

        double[][] matrix =(double[][]) Array.newInstance(double.class, dims);
        System.out.println(Arrays.deepToString(matrix));

    }
}

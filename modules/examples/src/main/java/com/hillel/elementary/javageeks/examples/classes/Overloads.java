package com.hillel.elementary.javageeks.examples.classes;


public class Overloads {

    public static String viewNum(Integer i) { // 1
        return String.format("Primitives=%d", i);
    }
    public static String viewNum(int i) { // 2
        return String.format("int=%d", i);
    }
    public static String viewNum(Float f) { // 3
        return String.format("Float=%.2f", f);
    }
    public static String viewNum(Number n) { // 4
        return String.format("Number=" + n);
    }

    public static void main(String[ ] args) {
        Number[ ] num = {new Integer(7), 71, 3.14f, 7.2 };
        for (Number n : num) {
            System.out.println(viewNum(n));
        }
        System.out.println(viewNum(new Integer(8)));
        System.out.println(viewNum(81));
        System.out.println(viewNum(4.14f));
        System.out.println(viewNum(8.2));
    }
}

package com.hillel.elementary.javageeks.examples.strings;

public class StringBuilderExample {

    public void example() {
        StringBuilder sb = new StringBuilder();
        System.out.println("длина ->" + sb.length());
        System.out.println("размер ->" + sb.capacity());
        //sb = "Java"; //ошибка, только для класса String
        sb.append("Java");
        System.out.println("строка ->" + sb);
        System.out.println("длина ->" + sb.length());
        System.out.println("размер ->" + sb.capacity());
        System.out.println("реверс ->" + sb.reverse());
    }
}

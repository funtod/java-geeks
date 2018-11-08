package com.hillel.elementary.javageeks.oleg.my_labs.lab_4;

public class TextConvert {
    static void convert(String field) throws MyExeption {
        System.out.println ("called method convert with field: " + field);
       if (field.length() < 10) throw new MyExeption (field);
            System.out.println ("normal completion");

        }
}

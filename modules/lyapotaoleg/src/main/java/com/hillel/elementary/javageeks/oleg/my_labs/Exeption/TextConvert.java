package com.hillel.elementary.javageeks.oleg.my_labs.Exeption;

public class TextConvert {
    static String convert(String field) throws MyExeption {
        if (field.length () < 10) throw new MyExeption (field);
        else System.out.println (field);
        return field;
    }
}

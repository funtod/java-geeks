package com.hillel.elementary.javageeks.task4;

public class Converter {

    public static Double convert(String s) {
        try{
            return Double.parseDouble(s);
        }
        catch (NullPointerException | NumberFormatException ex){
            return Double.NaN;
        }

    }
}
